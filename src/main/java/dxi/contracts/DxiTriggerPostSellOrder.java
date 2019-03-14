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
public class DxiTriggerPostSellOrder extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405160608061045c8339810180604052606081101561003057600080fd5b508051602082015160409092015160008054600160a060020a03938416600160a060020a0319918216179091556001805492841692821692909217909155600280549290931691161790556103d28061008a6000396000f3fe608060405234801561001057600080fd5b5060043610610052577c01000000000000000000000000000000000000000000000000000000006000350463c95cd1d28114610057578063d1ede21c14610130575b600080fd5b61012e600480360360c081101561006d57600080fd5b8135919081019060408101602082013564010000000081111561008f57600080fd5b8201836020820111156100a157600080fd5b803590602001918460018302840111640100000000831117156100c357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505073ffffffffffffffffffffffffffffffffffffffff8335811694506020840135169260408101359250606001359050610161565b005b61013861038a565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60008054604080517f10a96504000000000000000000000000000000000000000000000000000000008152600481018a81526024820192835289516044830152895160609573ffffffffffffffffffffffffffffffffffffffff909516946310a96504948d948d9493919260649091019160208601918190849084905b838110156101f65781810151838201526020016101de565b50505050905090810190601f1680156102235780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561024357600080fd5b505af1158015610257573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052602081101561028057600080fd5b81019080805164010000000081111561029857600080fd5b820160208101848111156102ab57600080fd5b81516401000000008111828201871017156102c557600080fd5b5050600154604080517f59f96ae500000000000000000000000000000000000000000000000000000000815273ffffffffffffffffffffffffffffffffffffffff8c811660048301528b81166024830152604482018b9052606482018a9052825194985090921695506359f96ae59450608480830194509092918290030181600087803b15801561035557600080fd5b505af1158015610369573d6000803e3d6000fd5b505050506040513d604081101561037f57600080fd5b505050505050505050565b60015473ffffffffffffffffffffffffffffffffffffffff168156fea165627a7a72305820ec2dc550bdb4975b127f5558b025e2d42c44811d65895bfbb4c43963f84f5a130029";

    public static final String FUNC_DXINTERACTS = "dxInteracts";

    public static final String FUNC_VERIFYANDEXECUTE = "verifyAndExecute";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552544443568", "0x98d9f9e8DEbd4A632682ba207670d2a5ACD3c489");
        _addresses.put("1552542794242", "0x98d9f9e8DEbd4A632682ba207670d2a5ACD3c489");
    }

    @Deprecated
    protected DxiTriggerPostSellOrder(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DxiTriggerPostSellOrder(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DxiTriggerPostSellOrder(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DxiTriggerPostSellOrder(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> dxInteracts() {
        final Function function = new Function(FUNC_DXINTERACTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> verifyAndExecute(byte[] _blockHash, byte[] _proof, String sellToken, String buyToken, BigInteger auctionIndex, BigInteger amount) {
        final Function function = new Function(
                FUNC_VERIFYANDEXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_blockHash), 
                new org.web3j.abi.datatypes.DynamicBytes(_proof), 
                new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.generated.Uint256(auctionIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DxiTriggerPostSellOrder load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxiTriggerPostSellOrder(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DxiTriggerPostSellOrder load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxiTriggerPostSellOrder(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DxiTriggerPostSellOrder load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DxiTriggerPostSellOrder(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DxiTriggerPostSellOrder load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DxiTriggerPostSellOrder(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _storeAddr, String _verifierAddr, String _dxInteractsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storeAddr), 
                new org.web3j.abi.datatypes.Address(_verifierAddr), 
                new org.web3j.abi.datatypes.Address(_dxInteractsAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
