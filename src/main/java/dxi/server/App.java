package dxi.server;

import java.math.BigInteger;
import java.util.List;

import javax.naming.spi.ResolveResult;

import java.util.Arrays;

import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.tx.TransactionManager;

import org.web3j.utils.Numeric;
import org.web3j.rlp.*;

import dxi.contracts.DutchExchange;
import dxi.contracts.DxInteracts;
import dxi.contracts.EtherToken;
import dxi.contracts.TokenGNO;
import dxi.contracts.DxiClaimAuction;

//For testing
import dxi.contracts.DxiTriggerPostSellOrder;
import dxi.contracts.EventEmitter;

import dxi.server.Utility;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> accounts = Resources.getAccounts();
        TransactionManager ctm1 = Resources.getClientManager(accounts.get(0));
        TransactionManager ctm2 = Resources.getClientManager(accounts.get(1));

        DutchExchange dx = Resources.getDxInstance(ctm1);
        // note that dxi is initialised with the second default account
        DxInteracts dxi = Resources.getDxiInstance(ctm2);
        TokenGNO gno = Resources.getGnoInstance(ctm1);
        EtherToken weth = Resources.getWethInstance(ctm2);
        DxiClaimAuction dxiClaimAuction = Resources.getDxiClaimAuctionInstance(ctm1);

        //For testing
        DxiTriggerPostSellOrder dxiTriggerPostSellOrder = Resources.getDxiTriggerPostSellOrderInstance(ctm1);
        EventEmitter eventEmitter = Resources.getEventEmitterInstance(ctm1);

        DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf("earliest");
        DefaultBlockParameter endBlock = DefaultBlockParameter.valueOf("latest");
        // Utility.activateLogs(startBlock, endBlock, dx);

        // 20 ether
        BigInteger startingETH = Utility.toWei(20L);
        // 50e18 GNO tokens
        BigInteger startingGNO = Utility.toWei(50L);
        
        // Deposit GNO into the DutchExchange
        // gno.approve(dx.getContractAddress(), startingGNO).send();
        // dx.deposit(gno.getContractAddress(), startingGNO).send();
        
        // Deposit 20 Ether into the DutchExchange as WETH (dxi converts it for you)
        dxi.depositEther(startingETH).send();
        // System.out.println("dxi balance -> post: " + dxi.balances(Resources.WETH_ADDRESS, accounts.get(1)).send());
        // Add token pair WETH <-> GNO on DutchExchange
        BigInteger token1Funding = Utility.toWei(10L);
        BigInteger token2Funding = BigInteger.valueOf(0L);
        BigInteger initialClosingPriceNum = BigInteger.valueOf(2L);
        BigInteger initialClosingPriceDen = BigInteger.valueOf(1L);
        dxi.addTokenPair(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, token1Funding, token2Funding, initialClosingPriceNum, initialClosingPriceDen).send();
        
        // Post WETH sell order on auctio

        dx.newSellOrderEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("sell order: " + e.amount);
        });

        // dxi.postSellOrder(Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, BigInteger.ZERO, BigInteger.valueOf(22L)).send();
    }

    
}
