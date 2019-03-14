package dxi.server;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.http.HttpService;


import dxi.contracts.DutchExchange;
import dxi.contracts.DxiClaimAuction;

import dxi.server.Resources;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;

public class Utility {

    public static List<String> getAccounts(Web3j web3) throws IOException {
        return web3.ethAccounts().send().getAccounts();
    }
    
    public static void activateLogs( DefaultBlockParameter startBlock, DefaultBlockParameter endBlock, DutchExchange dx) {
        Map<String, String> contractName = new HashMap<String, String>() {{
            put(Resources.DX_ADDRESS.toUpperCase(), "DutchExchange");
            put(Resources.DXI_ADDRESS.toUpperCase(), "DxInteracts");
            put(Resources.WETH_ADDRESS.toUpperCase(), "WETH");
            put(Resources.GNO_ADDRESS.toUpperCase(), "GNO");
        }};
        
        dx.newTokenPairEventFlowable(startBlock, endBlock).subscribe(e -> {
            String result = "New Token Pair." + System.lineSeparator() + 
            "buy token: " + contractName.get(e.buyToken.toUpperCase()) + ", " +
            "sell token: " + contractName.get(e.sellToken.toUpperCase());
            System.out.println(System.lineSeparator() + result);
            
        });
        
        dx.newSellOrderEventFlowable(startBlock, endBlock).subscribe(e -> {
            String result = "New Sell Order." + System.lineSeparator() + 
            "buy token: " + contractName.get(e.buyToken.toUpperCase()) + ", " +
            "sell token: " + contractName.get(e.sellToken.toUpperCase()) + ", " +
            "amount: " + e.amount + ", " +
            "user: " + e.user;
            System.out.println(System.lineSeparator() + result);
        });
        
        dx.newBuyOrderEventFlowable(startBlock, endBlock).subscribe(e -> {
            String result = "New Buy Order." + System.lineSeparator() + 
            "buy token: " + contractName.get(e.buyToken.toUpperCase()) + ", " +
            "sell token: " + contractName.get(e.sellToken.toUpperCase()) + ", " +
            "amount: " + e.amount + ", " +
            "user: " + e.user;
            System.out.println(System.lineSeparator() + result); 
        });
        
        // This prints out all dutchX deposits. Suitable for dev environment
        dx.newDepositEventFlowable(startBlock, endBlock).subscribe(e -> {
            String result = "DutchExchange deposit." + System.lineSeparator() + 
            "token: " + contractName.get(e.token.toUpperCase()) + ", " +
            "amount: " + e.amount;
            System.out.println(System.lineSeparator() + result);
        });
        
        dx.auctionClearedEventFlowable(startBlock, endBlock).subscribe(e -> {
            // if its our auction
            // TODO: check if sell or buy volume

            System.out.println("auction cleared");
        });
        
        dx.newSellerFundsClaimEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("seller claimed: " + e.amount); 
        });
        
        dx.newBuyerFundsClaimEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("buyer claimed: " + e.amount); 
        });
    
        dx.newWithdrawalEventFlowable(startBlock, endBlock).subscribe(e -> {
            System.out.println("withdrawn: " + e.amount + " of " + contractName.get(e.token.toUpperCase()));
        });
    }

    public static BigInteger getOutstandingVolume(DutchExchange dx, String sellTokenAddress, String buyTokenAddress, BigInteger auctionIndex) throws Exception {
        BigInteger sellVolume = dx.sellVolumesCurrent(sellTokenAddress, buyTokenAddress).send();
        BigInteger buyVol = dx.buyVolumes(sellTokenAddress, buyTokenAddress).send();
        Tuple2<BigInteger, BigInteger> priceFraction = dx.getCurrentAuctionPrice(sellTokenAddress, buyTokenAddress, auctionIndex).send();
        BigInteger price = priceFraction.getValue1().divide(priceFraction.getValue2());
        
        BigInteger outstandingVolume = sellVolume.multiply(price).subtract(buyVol);
        
        return outstandingVolume;
    }

    public static void evmSkipTime(Integer seconds) throws IOException {
        new Request("evm_increaseTime", Arrays.asList(seconds), new HttpService(), Response.class).send();
        new Request("evm_mine", Collections.EMPTY_LIST, new HttpService(), Response.class).send();
    }

    public static BigInteger toWei(Long ethValue) {
        BigInteger weiValue = BigInteger.valueOf(ethValue).multiply(BigInteger.valueOf(10).pow(18));
        return weiValue;
    }


    public static byte[] getProof(String clientUrl, String txHash){
        ByteByReference proofRef = LibIon.INSTANCE.getIonProof(clientUrl, clientUrl.length(), txHash, txHash.length());
        Pointer p = proofRef.getPointer();

        int proofLength = LibIon.INSTANCE.getIonProofLength(clientUrl, clientUrl.length(), txHash, txHash.length());

        byte[] arr = p.getByteArray(0, proofLength);
        return arr;
    }

    private final static char[] hexArray = "0123456789abcdef".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2 + 2];
        hexChars[0] = '0';
        hexChars[1] = 'x';

        for (int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2 + 2] = hexArray[v >>> 4]; //j * 2 + 2 for 0x
            hexChars[j * 2 + 3] = hexArray[v & 0x0F]; //j * 2 + 1 + 2 for 0x
        }
        return new String(hexChars);
    }

    // Java Native Access Library to used the ion shared object library
    public interface LibIon extends Library {

        public static LibIon INSTANCE = (LibIon)Native.loadLibrary("ion", LibIon.class);

        public ByteByReference getIonProof(String url, int urlLength, String txHash, int txHashLength);

        public int getIonProofLength(String url, int urlLength, String txHash, int txHashLength);

    }
}