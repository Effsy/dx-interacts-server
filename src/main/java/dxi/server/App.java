package dxi.server;

import java.math.BigInteger;
import java.util.List;
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
        



        // // Event verifier test
        // eventEmitter.eventOfInterestEventFlowable(startBlock, endBlock).subscribe(e -> {
        //     // if its our auction
        //     // TODO: check if sell or buy volume
            
        //     byte[] proof = Utility.getProof("http://localhost:8545", e.log.getTransactionHash());            
        //     String proofString = Utility.bytesToHex(proof);

        //     System.out.println("Generated the MPT proof for the auction cleared event: " + proofString);
            
        //     List<RlpType> rlpValues = RlpDecoder.decode(proof).getValues();     

        //     // Place sell order
        //     dxiTriggerPostSellOrder.verifyAndExecute(Numeric.hexStringToByteArray(e.log.getBlockHash()), proof, Resources.WETH_ADDRESS, Resources.GNO_ADDRESS, auctionIndex + 1, sellOrderAmount).send();

        //     System.out.println("Post sell order placed, triggered by an event");
        // });
        //
        // // Trigger the event verifier
        // eventEmitter.emitEvent().send();
        // System.out.println("An event was emitted (manually) to simulate an on-chain event");


        // // Test auction clearing event submission test
        // dx.auctionClearedEventFlowable(startBlock, endBlock).subscribe(e -> {
            
        //     byte[] proof = Utility.getProof("http://localhost:8545", e.log.getTransactionHash());            
        //     String proofString = Utility.bytesToHex(proof);

        //     System.out.println("Generated the MPT proof for the auction cleared event: " + proofString);
            
        //     System.out.println(e.sellToken);
        //     System.out.println(e.buyToken);
        //     System.out.println(dxi.getContractAddress());
        //     System.out.println(e.auctionIndex);
        //     System.out.println(e.sellVolume);
        //     System.out.println(e.log.getBlockHash());
        //     System.out.println(Numeric.hexStringToByteArray(e.log.getBlockHash()));
        //     System.out.println(e.log.getTransactionHash());
            
        //     List<RlpType> rlpValues = RlpDecoder.decode(proof).getValues();
        //     System.out.println(rlpValues.get(0));

        //     dxiClaimAuction.verifyAndExecute(Numeric.hexStringToByteArray(e.log.getBlockHash()), proof, e.sellToken, e.buyToken, dxi.getContractAddress(), e.auctionIndex, e.sellVolume).send();

        //     System.out.println("auction cleared");
        // });
    }

    
}
