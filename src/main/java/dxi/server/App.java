package dxi.server;

import java.util.List;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.tx.TransactionManager;

import dxi.contracts.DutchExchange;
import dxi.contracts.DxInteracts;
import dxi.server.Resources;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> accounts = Resources.getAccounts();
        // This is the wallet that will be managing dx and dxi
        TransactionManager ctm1 = Resources.getClientManager(accounts.get(0));
        TransactionManager ctm2 = Resources.getClientManager(accounts.get(1));

        DutchExchange dx = Resources.getDxInstance(ctm1);
<<<<<<< HEAD
        DxInteracts dxi = Resources.getDxiInstance(ctm1);
=======
        // note that dxi is initialised with the second default account
        DxInteracts dxi = Resources.getDxiInstance(ctm2);
        TokenGNO gno = Resources.getGnoInstance(ctm1);
        EtherToken weth = Resources.getWethInstance(ctm2);
        DxiClaimAuction dxiClaimAuction = Resources.getDxiClaimAuctionInstance(ctm1);

        //For testing
        DxiTriggerPostSellOrder dxiTriggerPostSellOrder = Resources.getDxiTriggerPostSellOrderInstance(ctm1);
        EventEmitter eventEmitter = Resources.getEventEmitterInstance(ctm1);
>>>>>>> dev

        // For live version, consider setting start="latest" and end="pending"
        DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf("earliest");
        DefaultBlockParameter endBlock = DefaultBlockParameter.valueOf("latest");
<<<<<<< HEAD
=======
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
        // System.out.println("dxi balance -> post: " + dxi.balances(Resources.WETH_ADDRESS, accounts.get(1)).send());
        // Add token pair WETH <-> GNO on DutchExchange
        BigInteger token1Funding = Utility.toWei(10L);
        BigInteger token2Funding = BigInteger.valueOf(0L);
        BigInteger initialClosingPriceNum = BigInteger.valueOf(2L);
        BigInteger initialClosingPriceDen = BigInteger.valueOf(1L);
        dxi.addTokenPair(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, token1Funding, token2Funding, initialClosingPriceNum, initialClosingPriceDen).send();
        
        // Post WETH sell order on auction
        BigInteger auctionIndex = dx.getAuctionIndex(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS).send();
        BigInteger sellOrderAmount = BigInteger.valueOf(10000L);
        dxi.postSellOrder(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, sellOrderAmount).send();
        
        // Skip evm time ~6hrs for auction to open
        Utility.evmSkipTime(22000);
        
        BigInteger buyOrderAmount = BigInteger.valueOf(10000L);
        dx.postBuyOrder(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex, buyOrderAmount).send();
        
        BigInteger preSellerFunds = dx.balances(Resources.GNO_ADDRESS, dxi.getContractAddress()).send();
        // Skip evm time for auction to close
        Utility.evmSkipTime(2200000);
        dxi.claimSellerFunds(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex).send();
        BigInteger postSellerFunds = dxi.balances(Resources.GNO_ADDRESS, accounts.get(1)).send();        
        System.out.println("dx balance -> pre: " + preSellerFunds + ", post: " + postSellerFunds);
        
        BigInteger preGnoFunds = gno.balanceOf(accounts.get(1)).send();
        // BigInteger preGnoFunds = gno.balanceOf(dxi.getContractAddress()).send();
        dxi.withdraw(Resources.GNO_ADDRESS, postSellerFunds).send();
        BigInteger postGnoFunds = gno.balanceOf(accounts.get(1)).send();
        
        System.out.println("GNO balance of dxi after withdrawal: " + gno.balanceOf(dxi.getContractAddress()).send());
        System.out.println("gno balance of account -> pre: " + preGnoFunds + ", post: " + postGnoFunds + ", diff: " + postGnoFunds.subtract(preGnoFunds));
        // dx.claimBuyerFunds(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, accounts.get(0), auctionIndex).send();
        // dx.withdraw(Resources.GNO_ADDRESS, BigInteger.valueOf(9950L)).send();


>>>>>>> dev


        System.out.println("hello world");

        dx.auctionClearedEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("auction cleared");
        });

        dx.newDepositEventFlowable(startBlock, endBlock).subscribe(e -> {
            String result = "still running";
            System.out.println(System.lineSeparator() + result);
        });
    }
}
