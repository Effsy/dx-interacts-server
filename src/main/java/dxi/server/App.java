package dxi.server;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import java.nio.charset.StandardCharsets;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlock.Block;


import org.web3j.tx.TransactionManager;
import org.web3j.utils.Numeric;
import org.web3j.crypto.Hash;

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
        // String txhash = "";
        // byte[] proof = Utility.getProof("http://localhost:8545", txhash);

        // Web3j web3 = Resources.getWeb3Provider();

        // DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf(new BigInteger("400000"));
        // Block block = web3.ethGetBlockByNumber(startBlock, true).send().getBlock();

 
        

        // System.out.println();
        // System.out.println("BlockData");

        // System.out.println(block.getParentHash().getBytes(StandardCharsets.UTF_8));
        // System.out.println(block.getSha3Uncles());
        // System.out.println(block.getMiner()); 
        // System.out.println(block.getStateRoot());
        // System.out.println(block.getTransactionsRoot());
        // System.out.println(block.getReceiptsRoot());
        // System.out.println(block.getLogsBloom());
        // System.out.println(Utility.parseZeroHexRlp(block.getDifficultyRaw()));
        // System.out.println(Utility.parseZeroHexRlp(block.getNumberRaw()));
        // System.out.println(Utility.parseZeroHexRlp(block.getGasLimitRaw()));
        // System.out.println(Utility.parseZeroHexRlp(block.getGasUsedRaw()));
        // System.out.println(Utility.parseZeroHexRlp(block.getTimestampRaw()));
        // System.out.println(block.getExtraData());
        // System.out.println(block.getMixHash());
        // System.out.println(Numeric.toHexStringWithPrefix(block.getNonce()));

        // System.out.println(Utility.bytesToHex(result));
        // System.out.println(Utility.bytesToHex(Hash.sha3(result)));

        // String blockHash = block.getHash();
        // System.out.println(blockHash);

        // System.out.println(
        //     Utility.hexToASCII(hexString)
        // );

        // for(RlpType curr : result.getValues()) {
        //     RlpString value = (RlpString) curr;
        //     System.out.print(Utility.hexToASCII(value.asString()));
        // }

        // for(String s : Utility.rlpToASCII(rlpList)) {
        //     System.out.println(s);
        // }

        
        //Emit event
        //Listen for event
        // Generate blockheader and proof
        //Submit to dxiPostSellOrder 

        List<String> accounts = Resources.getAccounts();
        TransactionManager ctm1 = Resources.getClientManager(accounts.get(0));
        TransactionManager ctm2 = Resources.getClientManager(accounts.get(1));

        DxiTriggerPostSellOrder dxiTriggerPostSellOrder = Resources.getDxiTriggerPostSellOrderInstance(ctm1);
        EventEmitter eventEmitter = Resources.getEventEmitterInstance(ctm1);
        DefaultBlockParameter startBlock = DefaultBlockParameter.valueOf("earliest");
        DefaultBlockParameter endBlock = DefaultBlockParameter.valueOf("latest");

        // Event verifier test
        eventEmitter.eventOfInterestEventFlowable(startBlock, endBlock).subscribe(e -> {
            // if its our auction
            // TODO: check if sell or buy volume
            
            byte[] proof = Utility.getProof("http://localhost:8545", e.log.getTransactionHash());            
            
            byte[] rlpEncodedBlockHeader = Utility.getRLPEncodedBlockHeader(e.log.getBlockNumber());

            System.out.println("txhash  " + e.log.getTransactionHash());

            System.out.println("Generated the MPT proof for the auction cleared event: " + Utility.bytesToHex(proof));
            System.out.println("Generated RLP encoded BlockHeader: " + Utility.bytesToHex(rlpEncodedBlockHeader));
            
            String address = "0x07a435c7b9df1F331505DdC05165473BEBeAFCdB";

            // Place sell order
            dxiTriggerPostSellOrder.verifyAndExecute(rlpEncodedBlockHeader, proof).send();

            System.out.println("Post sell order placed, triggered by an event");
        });
        
        // Trigger the event verifier
        eventEmitter.emitEvent().send();
        System.out.println("An event was emitted (manually) to simulate an on-chain event");


    }
    

    public static void _main(String[] args) throws Exception {
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
