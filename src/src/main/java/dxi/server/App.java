/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dxi.server;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

// import org.web3j.generated.*;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;


public class App {
    private static final Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
    private static final StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT);
    
    public static List<String> getAccounts() throws IOException {
        return web3.ethAccounts().send().getAccounts();
    }

    private static BigInteger toWei(Long l) {
        var ethValue = BigInteger.valueOf(l).multiply(BigInteger.valueOf(10).pow(18));
        return ethValue;
    }

    public static void main(String[] args) throws Exception {
        
        var accounts = getAccounts();
        var ctm1 = new ClientTransactionManager(web3, accounts.get(0));
        var ctm2 = new ClientTransactionManager(web3, accounts.get(1));
        
        
        String dutchExchangeAddress = "0x13274fe19c0178208bcbee397af8167a7be27f6f";
        String dxInteractsAddress = "0x2a504b5e7ec284aca5b6f49716611237239f0b97";
        String wethAddress = "0x345ca3e014aaf5dca488057592ee47305d9b3e10";
        String gnoAddress = "0x8f0483125fcb9aaaefa9209d8e9d7b9c8b9fb90f";
        

        // to call functions with different accounts, choose a different ClientTransactionManager
        DutchExchange dx = new DutchExchange(dutchExchangeAddress, web3, ctm1, gasProvider);
        DxInteracts dxi = new DxInteracts(dxInteractsAddress, web3, ctm1, gasProvider);
        TokenGNO gno = new TokenGNO(gnoAddress, web3, ctm1, gasProvider);
        // EtherToken weth = new EtherToken(wethAddress, web3, ctm1, gasProvider);
        

        var startingETH = toWei(20L);
        var startingGNO = toWei(50L);

        var prevWethBalance = dx.balances(wethAddress, dxi.getContractAddress()).send();
        dxi.depositEther(startingETH).send();
        var postWethBalance = dx.balances(wethAddress, dxi.getContractAddress()).send();
        
        // Transfering initial supply of GNO to dxi
        gno.transfer(dxi.getContractAddress(), startingGNO).send();
        
        var prevGnoBalance = dx.balances(gnoAddress, dxi.getContractAddress()).send();
        dxi.depositToken(gnoAddress, startingGNO).send();
        var postGnoBalance = dx.balances(gnoAddress, dxi.getContractAddress()).send();
        
        
        System.out.println("weth balance of dxi in dx: " + prevWethBalance);
        System.out.println("weth balance of dxi in dx: " + postWethBalance);
        System.out.println("gno balance of dxi in dx: " + prevGnoBalance);
        System.out.println("gno balance of dxi in dx: " + postGnoBalance);
        
        var token1Funding = toWei(10L);
        var token2Funding = BigInteger.valueOf(0L);
        var initialClosingPriceNum = BigInteger.valueOf(2L);
        var initialClosingPriceDen = BigInteger.valueOf(1L);

        var startBlock = DefaultBlockParameter.valueOf("earliest");
        var endBlock = DefaultBlockParameter.valueOf("latest");
        
        dx.newTokenPairEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("new token pair");
            System.out.println("buy token: " + e.buyToken + ", sell token: " + e.sellToken);
            System.out.println(e.sellToken.equals(wethAddress) + " " + e.buyToken.equals(gnoAddress));
        });
        
        dx.newSellOrderEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("new sell order");
            System.out.println("buy token: " + e.buyToken + ", sell token: " + e.sellToken + ", amount: " + e.amount);
            System.out.println(e.sellToken.equals(wethAddress) + " " + e.buyToken.equals(gnoAddress));
        });

        dxi.addTokenPair(wethAddress, gnoAddress, token1Funding, token2Funding, initialClosingPriceNum, initialClosingPriceDen).send();

        // System.out.println("here1");
        // Thread.sleep(10000);
        // System.out.println("here2");

        // dxi.postSellOrder(wethAddress, gnoAddress, auctionIndex, sellOrderAmount).send();

        var auctionIndex = dx.getAuctionIndex(wethAddress, gnoAddress).send();
        var sellOrderAmount = BigInteger.valueOf(10000L);
        dxi.postSellOrder(wethAddress, gnoAddress, auctionIndex, sellOrderAmount).send();
    }
}
