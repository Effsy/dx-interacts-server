package dxi.server;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import dxi.contracts.DutchExchange;
import dxi.contracts.DxInteracts;
import dxi.contracts.EtherToken;
import dxi.contracts.TokenGNO;
import dxi.server.Utility;

public class Resources {
    
    private static Web3j web3;
    private static List<String> accounts;
    private static Map<String, TransactionManager> transactionManager = new HashMap<>();
    
    public static final StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT);
    public static final String DX_ADDRESS = "0x2a504B5e7eC284ACa5b6f49716611237239F0b97";
    public static final String DXI_ADDRESS = "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c";
    public static final String WETH_ADDRESS = "0xf204a4Ef082f5c04bB89F7D5E6568B796096735a";
    public static final String GNO_ADDRESS = "0x2C2B9C9a4a25e24B174f26114e8926a9f2128FE4";
    
    private static Map<TransactionManager, DutchExchange> dx = new HashMap<>();
    private static Map<TransactionManager, DxInteracts> dxi = new HashMap<>();
    private static Map<TransactionManager, TokenGNO> gno = new HashMap<>();
    private static Map<TransactionManager, EtherToken> weth = new HashMap<>();
    

    public static Web3j getWeb3Provider() {
        if(web3 == null) {
            web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/
        }
        return web3;
    }
    
    public static List<String> getAccounts() throws IOException {
        if(accounts == null) {
            accounts = Utility.getAccounts(getWeb3Provider());
        }
        return accounts;
    }

    public static TransactionManager getClientManager(String account) {
        if(transactionManager.get(account) == null) {
            transactionManager.put(account, new ClientTransactionManager(getWeb3Provider(), account));
        }
        return transactionManager.get(account);
    }
    
    public static DutchExchange getDxInstance(TransactionManager ctm) {
        if(dx.get(ctm) == null) {
            dx.put(ctm, DutchExchange.load(DX_ADDRESS, getWeb3Provider(), ctm, gasProvider));
        }
        return dx.get(ctm);
    }

    public static DxInteracts getDxiInstance(TransactionManager ctm) {
        if(dxi.get(ctm) == null) {
            dxi.put(ctm, DxInteracts.load(DXI_ADDRESS, getWeb3Provider(), ctm, gasProvider));
        }
        return dxi.get(ctm);
    }

    public static TokenGNO getGnoInstance(TransactionManager ctm) {
        if(gno.get(ctm) == null) {
            gno.put(ctm, TokenGNO.load(GNO_ADDRESS, getWeb3Provider(), ctm, gasProvider));
        }
        return gno.get(ctm);
    }

    public static EtherToken getWethInstance(TransactionManager ctm) {
        if(weth.get(ctm) == null) {
            weth.put(ctm, EtherToken.load(WETH_ADDRESS, getWeb3Provider(), ctm, gasProvider));
        }
        return weth.get(ctm);
    }
}