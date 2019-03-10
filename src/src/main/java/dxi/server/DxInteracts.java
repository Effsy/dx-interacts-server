package dxi.server;

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
public class DxInteracts extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50604051604080610d688339810180604052604081101561003057600080fd5b508051602090910151600160a060020a03811615156100b057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f54686520574554482061646472657373206d7573742062652076616c69640000604482015290519081900360640190fd5b600160a060020a0382161515610111576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180610d466022913960400191505060405180910390fd5b60008054600160a060020a03938416600160a060020a03199182161790915560018054929093169116179055610bfa8061014c6000396000f3fe60806040526004361061008a5760003560e060020a9004806398ea5fca1161005d57806398ea5fca146101ce578063c9042b1e146101d8578063d33128d2146101ed578063e9f8cd701461023c578063fd706564146102915761008a565b8063338b5dea1461008f57806359f96ae5146100da578063657a37ad1461013c5780637bf1a6271461019d575b600080fd5b34801561009b57600080fd5b506100c8600480360360408110156100b257600080fd5b50600160a060020a0381351690602001356102b7565b60408051918252519081900360200190f35b3480156100e657600080fd5b50610123600480360360808110156100fd57600080fd5b50600160a060020a038135811691602081013590911690604081013590606001356103e1565b6040805192835260208301919091528051918290030190f35b34801561014857600080fd5b5061017f6004803603606081101561015f57600080fd5b50600160a060020a0381358116916020810135909116906040013561049d565b60408051938452602084019290925282820152519081900360600190f35b3480156101a957600080fd5b506101b26105e6565b60408051600160a060020a039092168252519081900360200190f35b6101d66105f5565b005b3480156101e457600080fd5b506101b261078c565b3480156101f957600080fd5b5061017f600480360360a081101561021057600080fd5b50600160a060020a0381358116916020810135821691604082013516906060810135906080013561079b565b34801561024857600080fd5b506101d6600480360360c081101561025f57600080fd5b50600160a060020a03813581169160208101359091169060408101359060608101359060808101359060a001356108ff565b61017f600480360360208110156102a757600080fd5b5035600160a060020a03166109a7565b600080546040805160e060020a63095ea7b3028152600160a060020a0392831660048201526024810185905290519185169163095ea7b39160448082019260209290919082900301818787803b15801561031057600080fd5b505af1158015610324573d6000803e3d6000fd5b505050506040513d602081101561033a57600080fd5b505060008054604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483015260248201879052915191909216926347e7ef2492604480820193602093909283900390910190829087803b1580156103ae57600080fd5b505af11580156103c2573d6000803e3d6000fd5b505050506040513d60208110156103d857600080fd5b50519392505050565b60008054604080517f59f96ae5000000000000000000000000000000000000000000000000000000008152600160a060020a038881166004830152878116602483015260448201879052606482018690528251859491909116926359f96ae5926084808201939182900301818787803b15801561045d57600080fd5b505af1158015610471573d6000803e3d6000fd5b505050506040513d604081101561048757600080fd5b5080516020909101519097909650945050505050565b600080546040805160e060020a63095ea7b3028152600160a060020a039283166004820152602481018590529051839283929088169163095ea7b39160448082019260209290919082900301818787803b1580156104fa57600080fd5b505af115801561050e573d6000803e3d6000fd5b505050506040513d602081101561052457600080fd5b505060008054604080517f657a37ad000000000000000000000000000000000000000000000000000000008152600160a060020a038a811660048301528981166024830152604482018990529151919092169263657a37ad92606480820193606093909283900390910190829087803b1580156105a057600080fd5b505af11580156105b4573d6000803e3d6000fd5b505050506040513d60608110156105ca57600080fd5b5080516020820151604090920151909891975095509350505050565b600154600160a060020a031681565b600160009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff1660e060020a0281526004016000604051808303818588803b15801561064857600080fd5b505af115801561065c573d6000803e3d6000fd5b5050600154600080546040805160e060020a63095ea7b3028152600160a060020a039283166004820152346024820152905191909316955063095ea7b39450604480840194506020939192918390030190829087803b1580156106be57600080fd5b505af11580156106d2573d6000803e3d6000fd5b505050506040513d60208110156106e857600080fd5b505060008054600154604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a039283166004820152346024820152905191909216926347e7ef2492604480820193602093909283900390910190829087803b15801561075e57600080fd5b505af1158015610772573d6000803e3d6000fd5b505050506040513d602081101561078857600080fd5b5050565b600054600160a060020a031681565b60008054604080517f06d58f2a000000000000000000000000000000000000000000000000000000008152600160a060020a03898116600483015288811660248301528781166044830152606482018790526084820186905291518493849316916306d58f2a9160a480830192606092919082900301818787803b15801561082257600080fd5b505af1158015610836573d6000803e3d6000fd5b505050506040513d606081101561084c57600080fd5b50805160208083015160409384015184517fa9059cbb000000000000000000000000000000000000000000000000000000008152600160a060020a038c81166004830152602482018b905295519498509196509450928a169263a9059cbb92604480830193928290030181600087803b1580156108c857600080fd5b505af11580156108dc573d6000803e3d6000fd5b505050506040513d60208110156108f257600080fd5b5050955095509592505050565b60008054604080517fe9f8cd70000000000000000000000000000000000000000000000000000000008152600160a060020a038a81166004830152898116602483015260448201899052606482018890526084820187905260a482018690529151919092169263e9f8cd709260c4808201939182900301818387803b15801561098757600080fd5b505af115801561099b573d6000803e3d6000fd5b50505050505050505050565b6000806000600160009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff1660e060020a0281526004016000604051808303818588803b1580156109ff57600080fd5b505af1158015610a13573d6000803e3d6000fd5b5050600154600080546040805160e060020a63095ea7b3028152600160a060020a039283166004820152346024820152905191909316955063095ea7b39450604480840194506020939192918390030190829087803b158015610a7557600080fd5b505af1158015610a89573d6000803e3d6000fd5b505050506040513d6020811015610a9f57600080fd5b50511515610b0e57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f6661696c20746f20617070726f76652065746820746f6b656e00000000000000604482015290519081900360640190fd5b60008054600154604080517f657a37ad000000000000000000000000000000000000000000000000000000008152600160a060020a03928316600482015288831660248201523460448201529051919092169263657a37ad92606480820193606093909283900390910190829087803b158015610b8a57600080fd5b505af1158015610b9e573d6000803e3d6000fd5b505050506040513d6060811015610bb457600080fd5b50805160208201516040909201519096919550935091505056fea165627a7a72305820905f40e4d27714528867b94a54d9664161d22f1b8a3f13f9f70f9dfa2fb995620029447574636845786368616e67652063616e2774206861766520616464726573732030";

    public static final String FUNC_ETHTOKEN = "ethToken";

    public static final String FUNC_DX = "dx";

    public static final String FUNC_SELLETHER = "sellEther";

    public static final String FUNC_DEPOSITTOKEN = "depositToken";

    public static final String FUNC_DEPOSITETHER = "depositEther";

    public static final String FUNC_DEPOSITANDSELL = "depositAndSell";

    public static final String FUNC_POSTSELLORDER = "postSellOrder";

    public static final String FUNC_CLAIMAUCTION = "claimAuction";

    public static final String FUNC_ADDTOKENPAIR = "addTokenPair";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552240702094", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
    }

    @Deprecated
    protected DxInteracts(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DxInteracts(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DxInteracts(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DxInteracts(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> ethToken() {
        final Function function = new Function(FUNC_ETHTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> dx() {
        final Function function = new Function(FUNC_DX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> sellEther(String buyToken, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SELLETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(buyToken)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> depositToken(String _token, BigInteger _amount) {
        final Function function = new Function(
                FUNC_DEPOSITTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> depositEther(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSITETHER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> depositAndSell(String sellToken, String buyToken, BigInteger _amount) {
        final Function function = new Function(
                FUNC_DEPOSITANDSELL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> postSellOrder(String sellToken, String buyToken, BigInteger auctionIndex, BigInteger amount) {
        final Function function = new Function(
                FUNC_POSTSELLORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.generated.Uint256(auctionIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claimAuction(String sellToken, String buyToken, String user, BigInteger auctionIndex, BigInteger amount) {
        final Function function = new Function(
                FUNC_CLAIMAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint256(auctionIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addTokenPair(String token1, String token2, BigInteger token1Funding, BigInteger token2Funding, BigInteger initialClosingPriceNum, BigInteger initialClosingPriceDen) {
        final Function function = new Function(
                FUNC_ADDTOKENPAIR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token1), 
                new org.web3j.abi.datatypes.Address(token2), 
                new org.web3j.abi.datatypes.generated.Uint256(token1Funding), 
                new org.web3j.abi.datatypes.generated.Uint256(token2Funding), 
                new org.web3j.abi.datatypes.generated.Uint256(initialClosingPriceNum), 
                new org.web3j.abi.datatypes.generated.Uint256(initialClosingPriceDen)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DxInteracts load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxInteracts(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DxInteracts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DxInteracts(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DxInteracts load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DxInteracts(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DxInteracts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DxInteracts(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DxInteracts> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _dx, String _ethToken) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dx), 
                new org.web3j.abi.datatypes.Address(_ethToken)));
        return deployRemoteCall(DxInteracts.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DxInteracts> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _dx, String _ethToken) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dx), 
                new org.web3j.abi.datatypes.Address(_ethToken)));
        return deployRemoteCall(DxInteracts.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxInteracts> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _dx, String _ethToken) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dx), 
                new org.web3j.abi.datatypes.Address(_ethToken)));
        return deployRemoteCall(DxInteracts.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DxInteracts> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _dx, String _ethToken) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dx), 
                new org.web3j.abi.datatypes.Address(_ethToken)));
        return deployRemoteCall(DxInteracts.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
