package dxi.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405160408061074f8339810180604052604081101561003057600080fd5b50805160209091015160008054600160a060020a03928316600160a060020a031991821617909155600180549290931691161790556106db806100746000396000f3fe608060405234801561001057600080fd5b5060043610610047577c01000000000000000000000000000000000000000000000000000000006000350463795d7b0c811461004c575b600080fd5b6101a3600480360360c081101561006257600080fd5b81019060208101813564010000000081111561007d57600080fd5b82018360208201111561008f57600080fd5b803590602001918460018302840111640100000000831117156100b157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561010457600080fd5b82018360208201111561011657600080fd5b8035906020019184600183028401116401000000008311171561013857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505073ffffffffffffffffffffffffffffffffffffffff83358116945060208401351692604081013592506060013590506101a5565b005b60606101b18787610270565b600154604080517f59f96ae500000000000000000000000000000000000000000000000000000000815273ffffffffffffffffffffffffffffffffffffffff8981166004830152888116602483015260448201889052606482018790528251949550909216926359f96ae59260848082019392918290030181600087803b15801561023b57600080fd5b505af115801561024f573d6000803e3d6000fd5b505050506040513d604081101561026557600080fd5b505050505050505050565b60608061028461027f856102af565b6102fa565b90506102a781600381518110151561029857fe5b906020019060200201516103af565b949350505050565b6102b7610677565b81518015156102db57505060408051808201909152600080825260208201526102f5565b604080518082019091526020848101825281019190915290505b919050565b606061030582610407565b151561031057600080fd5b600061031b8361042e565b90508060405190808252806020026020018201604052801561035757816020015b610344610677565b81526020019060019003908161033c5790505b50915061036261068e565b61036b84610494565b905060005b610379826104cd565b156103a757610387826104ec565b848281518110151561039557fe5b60209081029091010152600101610370565b505050919050565b60208101516060908015156103c457506102f5565b806040519080825280601f01601f1916602001820160405280156103ef576020820181803883390190505b5091506104018360000151838361052c565b50919050565b600081602001516000141561041e575060006102f5565b50515160c060009190911a101590565b600061043982610407565b1515610447575060006102f5565b81518051600090811a919061045b8561056c565b6020860151908301915082016000190160005b81831161048a5761047e836105ea565b9092019160010161046e565b9695505050505050565b61049c61068e565b6104a582610407565b15156104b057600080fd5b60006104bb8361056c565b83519383529092016020820152919050565b60006104d7610677565b50508051602080820151915192015191011190565b6104f4610677565b6104fd826104cd565b156100475760208201516000610512826105ea565b8284526020808501829052920191840191909152506102f5565b60006020601f83010484602085015b8383146105595760208402828101519082015260019093019261053b565b6000865160200187015250505050505050565b6000816020015160001415610583575060006102f5565b8151805160001a90608082101561059f576000925050506102f5565b60b88210806105ba575060c082101580156105ba575060f882105b156105ca576001925050506102f5565b60c08210156105df575060b5190190506102f5565b5060f5190192915050565b8051600090811a60808110156106035760019150610401565b60b881101561061857607e1981019150610401565b60c081101561064157600183015160b76020839003016101000a9004810160b519019150610401565b60f88110156106565760be1981019150610401565b6001929092015160f76020849003016101000a900490910160f51901919050565b604080518082019091526000808252602082015290565b6060604051908101604052806106a2610677565b815260200160008152509056fea165627a7a7230582025b05e132df28f6a5c3bf31a8afcb42d3d7be427df15f178c10061c4c06cef050029";

    public static final String FUNC_VERIFYANDEXECUTE = "verifyAndExecute";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
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

    public RemoteCall<TransactionReceipt> verifyAndExecute(byte[] _proof, byte[] _blockHeader, String _sellToken, String _buyToken, BigInteger _auctionIndex, BigInteger _amount) {
        final Function function = new Function(
                FUNC_VERIFYANDEXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_proof), 
                new org.web3j.abi.datatypes.DynamicBytes(_blockHeader), 
                new org.web3j.abi.datatypes.Address(_sellToken), 
                new org.web3j.abi.datatypes.Address(_buyToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_auctionIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
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

    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _dxiAddress, String _verifierAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dxiAddress), 
                new org.web3j.abi.datatypes.Address(_verifierAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _dxiAddress, String _verifierAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dxiAddress), 
                new org.web3j.abi.datatypes.Address(_verifierAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _dxiAddress, String _verifierAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dxiAddress), 
                new org.web3j.abi.datatypes.Address(_verifierAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxiTriggerPostSellOrder> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _dxiAddress, String _verifierAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dxiAddress), 
                new org.web3j.abi.datatypes.Address(_verifierAddr)));
        return deployRemoteCall(DxiTriggerPostSellOrder.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
