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
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405160608061033b8339810180604052606081101561003057600080fd5b508051602082015160409092015160008054600160a060020a03938416600160a060020a0319918216179091556001805492841692821692909217909155600280549290931691161790556102b18061008a6000396000f3fe608060405234801561001057600080fd5b5060043610610052577c0100000000000000000000000000000000000000000000000000000000600035046341d6bfda8114610057578063d1ede21c14610139575b600080fd5b610137600480360360e081101561006d57600080fd5b8135919081019060408101602082013564010000000081111561008f57600080fd5b8201836020820111156100a157600080fd5b803590602001918460018302840111640100000000831117156100c357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505073ffffffffffffffffffffffffffffffffffffffff833581169450602084013581169360408101359091169250606081013591506080013561016a565b005b610141610269565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60008054604080517f10a96504000000000000000000000000000000000000000000000000000000008152600481018b8152602482019283528a5160448301528a5173ffffffffffffffffffffffffffffffffffffffff909416946310a96504948d948d94909260649091019160208601918190849084905b838110156101fb5781810151838201526020016101e3565b50505050905090810190601f1680156102285780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561024857600080fd5b505af115801561025c573d6000803e3d6000fd5b5050505050505050505050565b60015473ffffffffffffffffffffffffffffffffffffffff168156fea165627a7a72305820c66aeafdc56fdd5d67573ce8442f6d07d6950acd8a557224a9a19b2b71cc93d60029";

    public static final String FUNC_DXINTERACTS = "dxInteracts";

    public static final String FUNC_VERIFYANDEXECUTE = "verifyAndExecute";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552448847138", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450175306", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552449902377", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552451113250", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552447531996", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552449247995", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450052919", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450612332", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552447763019", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552482772432", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450454648", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552448725767", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552448968544", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552449527380", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552447668081", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552481127352", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450296348", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552450772480", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
        _addresses.put("1552482677787", "0x8273e4B8ED6c78e252a9fCa5563Adfcc75C91b2A");
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
