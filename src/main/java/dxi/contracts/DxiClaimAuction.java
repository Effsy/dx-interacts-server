package dxi.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class DxiClaimAuction extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516060806102458339810180604052606081101561003057600080fd5b508051602082015160409092015160008054600160a060020a03938416600160a060020a0319918216179091556001805492841692821692909217909155600280549290931691161790556101bb8061008a6000396000f3fe608060405234801561001057600080fd5b5060043610610052577c0100000000000000000000000000000000000000000000000000000000600035046341d6bfda8114610057578063d1ede21c14610139575b600080fd5b610137600480360360e081101561006d57600080fd5b8135919081019060408101602082013564010000000081111561008f57600080fd5b8201836020820111156100a157600080fd5b803590602001918460018302840111640100000000831117156100c357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505073ffffffffffffffffffffffffffffffffffffffff833581169450602084013581169360408101359091169250606081013591506080013561016a565b005b610141610173565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b50505050505050565b60015473ffffffffffffffffffffffffffffffffffffffff168156fea165627a7a72305820974e556e99898b86edc5b7973a420a1cf57566118e9315fd5c89f00da9cb81300029";

    public static final String FUNC_DXINTERACTS = "dxInteracts";

    public static final String FUNC_VERIFYANDEXECUTE = "verifyAndExecute";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552447531996", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552447668081", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
    }

    @Deprecated
    protected DxiClaimAuction(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DxiClaimAuction(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DxiClaimAuction(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DxiClaimAuction(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> dxInteracts() {
        final Function function = new Function(FUNC_DXINTERACTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> verifyAndExecute(byte[] _blockHash, byte[] _proof, String sellToken, String buyToken, String user, BigInteger auctionIndex, BigInteger amount) {
        final Function function = new Function(
                FUNC_VERIFYANDEXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_blockHash), 
                new org.web3j.abi.datatypes.DynamicBytes(_proof), 
                new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint256(auctionIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DxiClaimAuction load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxiClaimAuction(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DxiClaimAuction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxiClaimAuction(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DxiClaimAuction load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DxiClaimAuction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DxiClaimAuction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DxiClaimAuction(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DxiClaimAuction> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiClaimAuction.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DxiClaimAuction> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiClaimAuction.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiClaimAuction> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiClaimAuction.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiClaimAuction> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiClaimAuction.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
