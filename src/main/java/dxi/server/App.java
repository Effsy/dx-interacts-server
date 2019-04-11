package dxi.server;

import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;

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
    }
}
