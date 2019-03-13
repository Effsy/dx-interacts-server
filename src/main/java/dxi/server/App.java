package dxi.server;

import java.math.BigInteger;
import java.util.List;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.tx.TransactionManager;

import dxi.contracts.DutchExchange;
import dxi.contracts.DxInteracts;
import dxi.contracts.EtherToken;
import dxi.contracts.TokenGNO;

import dxi.server.Utility;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> accounts = Resources.getAccounts();
        TransactionManager ctm1 = Resources.getClientManager(accounts.get(0));

        DutchExchange dx = Resources.getDxInstance(ctm1);
        DxInteracts dxi = Resources.getDxiInstance(ctm1);
        TokenGNO gno = Resources.getGnoInstance(ctm1);
        EtherToken weth = Resources.getWethInstance(ctm1);
        
        DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf("earliest");
        DefaultBlockParameter endBlock = DefaultBlockParameter.valueOf("latest");
        Utility.activateLogs(startBlock, endBlock, dx);

        // 20 ether
        BigInteger startingETH = Utility.toWei(20L);
        // 50e18 GNO tokens
        BigInteger startingGNO = Utility.toWei(50L);
        
        // Deposit GNO into the DutchExchange
        gno.approve(dx.getContractAddress(), startingGNO).send();
        dx.deposit(gno.getContractAddress(), startingGNO).send();
        
        // Deposit 20 Ether into the DutchExchange as WETH (dxi converts it for you)
        dxi.depositEther(startingETH).send();
        
    
        // Add token pair WETH <-> GNO on DutchExchange
        BigInteger token1Funding = Utility.toWei(10L);
        BigInteger token2Funding = BigInteger.valueOf(0L);
        BigInteger initialClosingPriceNum = BigInteger.valueOf(2L);
        BigInteger initialClosingPriceDen = BigInteger.valueOf(1L);
        dxi.addTokenPair(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, token1Funding, token2Funding, initialClosingPriceNum, initialClosingPriceDen).send();
        
        // Post WETH sell order on auction
        BigInteger auctionIndex = dx.getAuctionIndex(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS).send();
        System.out.println("here: " + Utility.getOutstandingVolume(dx, Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex).toString());
        BigInteger sellOrderAmount = BigInteger.valueOf(10000L);
        dxi.postSellOrder(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, sellOrderAmount).send();
        
        // Skip evm time ~6hrs for auction to open
        Utility.evmSkipTime(22000);
        
        BigInteger buyOrderAmount = BigInteger.valueOf(10000L);
        dx.postBuyOrder(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, buyOrderAmount).send();
        
        Utility.evmSkipTime(2200000);        
        
        System.out.println("here: " + Utility.getOutstandingVolume(dx, Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex).toString());
        // sellerBalances[sellToken][buyToken][auctionIndex][user]
        
        System.out.println("gno balance in dx: " + dx.balances(Resources.GNO_ADDRESS, dxi.getContractAddress()).send().toString());
        dxi.claimSellerFunds(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, dxi.getContractAddress(), auctionIndex).send();
        System.out.println("gno balance in dx: " + dx.balances(Resources.GNO_ADDRESS, dxi.getContractAddress()).send().toString());
        
        
        System.out.println("weth balance in dx: " + dx.balances(Resources.WETH_ADDRESS, Resources.getAccounts().get(0)).send().toString());
        System.out.println("weth balance in dx: " + dx.balances(Resources.WETH_ADDRESS, Resources.getAccounts().get(0)).send().toString());
        
    
        System.out.println("buyer funds: " + dx.buyerBalances(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, Resources.getAccounts().get(0)).send().toString());
        dx.claimBuyerFunds(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, Resources.getAccounts().get(0), auctionIndex).send();
        System.out.println("buyer funds: " + dx.buyerBalances(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, Resources.getAccounts().get(0)).send().toString());
        
        System.out.println("weth balance: " + weth.balanceOf(Resources.getAccounts().get(0)).send().toString());
        dx.withdraw(Resources.GNO_ADDRESS, BigInteger.valueOf(9950L)).send();
        System.out.println("weth balance: " + weth.balanceOf(Resources.getAccounts().get(0)).send().toString());
    }
}
