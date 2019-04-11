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
        DxInteracts dxi = Resources.getDxiInstance(ctm1);

        // For live version, consider setting start="latest" and end="pending"
        DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf("earliest");
        DefaultBlockParameter endBlock = DefaultBlockParameter.valueOf("latest");


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
