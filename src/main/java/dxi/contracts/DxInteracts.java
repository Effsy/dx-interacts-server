package dxi.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516040806112698339810180604052604081101561003057600080fd5b508051602090910151600160a060020a03811615156100b057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f54686520574554482061646472657373206d7573742062652076616c69640000604482015290519081900360640190fd5b600160a060020a0382161515610111576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806112476022913960400191505060405180910390fd5b60038054600160a060020a03938416600160a060020a031991821617909155600480549290931691161790556110fb8061014c6000396000f3fe60806040526004361061012e5760003560e060020a9004806398ea5fca116100af578063c9042b1e11610073578063c9042b1e146104a0578063cb10fa76146104b5578063e31c71c4146104e5578063e9f8cd7014610515578063f3fef3a31461056c578063fd706564146105a55761012e565b806398ea5fca146103b4578063b67d77c5146103bc578063c1a21bf3146103ec578063c23f001f14610435578063c8a4ac9c146104705761012e565b806365054e55116100f657806365054e5514610297578063657a37ad146102e0578063771602f7146103235780637ae2b5c7146103535780637bf1a627146103835761012e565b80633069046814610133578063338b5dea1461016f57806337775807146101a85780634e30a66c146101f157806359f96ae514610235575b600080fd5b34801561013f57600080fd5b5061015d6004803603602081101561015657600080fd5b50356105cb565b60408051918252519081900360200190f35b34801561017b57600080fd5b5061015d6004803603604081101561019257600080fd5b50600160a060020a0381351690602001356105e5565b3480156101b457600080fd5b5061015d600480360360808110156101cb57600080fd5b50600160a060020a03813581169160208101358216916040820135916060013516610731565b3480156101fd57600080fd5b506102216004803603604081101561021457600080fd5b508035906020013561075d565b604080519115158252519081900360200190f35b34801561024157600080fd5b5061027e6004803603608081101561025857600080fd5b50600160a060020a0381358116916020810135909116906040810135906060013561076a565b6040805192835260208301919091528051918290030190f35b3480156102a357600080fd5b5061027e600480360360808110156102ba57600080fd5b50600160a060020a038135811691602081013582169160408201351690606001356108a5565b3480156102ec57600080fd5b5061027e6004803603606081101561030357600080fd5b50600160a060020a03813581169160208101359091169060400135610961565b34801561032f57600080fd5b5061015d6004803603604081101561034657600080fd5b5080359060200135610a0f565b34801561035f57600080fd5b5061015d6004803603604081101561037657600080fd5b5080359060200135610a2b565b34801561038f57600080fd5b50610398610a43565b60408051600160a060020a039092168252519081900360200190f35b61015d610a52565b3480156103c857600080fd5b5061015d600480360360408110156103df57600080fd5b5080359060200135610b6a565b3480156103f857600080fd5b5061015d6004803603608081101561040f57600080fd5b50600160a060020a03813581169160208101358216916040820135916060013516610b87565b34801561044157600080fd5b5061015d6004803603604081101561045857600080fd5b50600160a060020a0381358116916020013516610bb3565b34801561047c57600080fd5b5061015d6004803603604081101561049357600080fd5b5080359060200135610bcd565b3480156104ac57600080fd5b50610398610be9565b3480156104c157600080fd5b50610221600480360360408110156104d857600080fd5b5080359060200135610bf8565b3480156104f157600080fd5b506102216004803603604081101561050857600080fd5b5080359060200135610c1a565b34801561052157600080fd5b5061056a600480360360c081101561053857600080fd5b50600160a060020a03813581169160208101359091169060408101359060608101359060808101359060a00135610c1f565b005b34801561057857600080fd5b5061015d6004803603604081101561058f57600080fd5b50600160a060020a038135169060200135610cca565b61027e600480360360208110156105bb57600080fd5b5035600160a060020a0316610dce565b6000808212156105dd575060006105e0565b50805b919050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009285169163095ea7b391604480830192602092919082900301818787803b15801561063e57600080fd5b505af1158015610652573d6000803e3d6000fd5b505050506040513d602081101561066857600080fd5b5050600354604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a03868116600483015260248201869052915191909216916347e7ef249160448083019260209291908290030181600087803b1580156106d957600080fd5b505af11580156106ed573d6000803e3d6000fd5b505050506040513d602081101561070357600080fd5b5051600160a060020a0390931660009081526020818152604080832033845290915290208390555090919050565b600260209081526000948552604080862082529385528385208152918452828420909152825290205481565b8082018211155b92915050565b600354604080517f59f96ae5000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483015286811660248301526044820186905260648201859052825160009485949216926359f96ae592608480830193919282900301818787803b1580156107e757600080fd5b505af11580156107fb573d6000803e3d6000fd5b505050506040513d604081101561081157600080fd5b508051602091820151600160a060020a03891660009081528084526040808220338352909452929092205490935090915061084c9084610b6a565b600160a060020a0396871660008181526020818152604080832033808552908352818420959095559282526001815282822098909916815296885280872095875294875284862090865290955291909220819055929050565b600354604080517f65054e55000000000000000000000000000000000000000000000000000000008152600160a060020a038781166004830152868116602483015230604483015260648201859052825160009485949216926365054e5592608480830193919282900301818787803b15801561092157600080fd5b505af1158015610935573d6000803e3d6000fd5b505050506040513d604081101561094b57600080fd5b5080516020909101519097909650945050505050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009283929087169163095ea7b39160448082019260209290919082900301818787803b1580156109be57600080fd5b505af11580156109d2573d6000803e3d6000fd5b505050506040513d60208110156109e857600080fd5b506109f5905085846105e5565b50610a03858560008661076a565b91509150935093915050565b6000610a1b838361075d565b1515610a2657600080fd5b500190565b600081831015610a3c575081610764565b5080610764565b600454600160a060020a031681565b60048054604080517fd0e30db00000000000000000000000000000000000000000000000000000000081529051600093600160a060020a039093169263d0e30db092349281830192879282900301818588803b158015610ab157600080fd5b505af1158015610ac5573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b158015610b2357600080fd5b505af1158015610b37573d6000803e3d6000fd5b505050506040513d6020811015610b4d57600080fd5b5050600454610b6590600160a060020a0316346105e5565b905090565b6000610b768383610c1a565b1515610b8157600080fd5b50900390565b600160209081526000948552604080862082529385528385208152918452828420909152825290205481565b600060208181529281526040808220909352908152205481565b6000610bd98383610bf8565b1515610be457600080fd5b500290565b600354600160a060020a031681565b6000811580610c1357508282838502811515610c1057fe5b04145b9392505050565b111590565b600354604080517fe9f8cd70000000000000000000000000000000000000000000000000000000008152600160a060020a038981166004830152888116602483015260448201889052606482018790526084820186905260a482018590529151919092169163e9f8cd709160c480830192600092919082900301818387803b158015610caa57600080fd5b505af1158015610cbe573d6000803e3d6000fd5b50505050505050505050565b600354604080517ff3fef3a3000000000000000000000000000000000000000000000000000000008152600160a060020a038581166004830152602482018590529151600093929092169163f3fef3a39160448082019260209290919082900301818787803b158015610d3c57600080fd5b505af1158015610d50573d6000803e3d6000fd5b505050506040513d6020811015610d6657600080fd5b50519050610d778333846000610f68565b1515610764576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806110ae6022913960400191505060405180910390fd5b600080600460009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff1660e060020a0281526004016000604051808303818588803b158015610e2457600080fd5b505af1158015610e38573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b158015610e9657600080fd5b505af1158015610eaa573d6000803e3d6000fd5b505050506040513d6020811015610ec057600080fd5b50511515610f2f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f6661696c20746f20617070726f76652065746820746f6b656e00000000000000604482015290519081900360640190fd5b600454610f4590600160a060020a0316346105e5565b50600454610f5f90600160a060020a03168460003461076a565b91509150915091565b60008115610ffa57604080517f23b872dd000000000000000000000000000000000000000000000000000000008152336004820152306024820152604481018590529051600160a060020a038716916323b872dd91606480830192600092919082900301818387803b158015610fdd57600080fd5b505af1158015610ff1573d6000803e3d6000fd5b50505050611076565b84600160a060020a031663a9059cbb85856040518363ffffffff1660e060020a0281526004018083600160a060020a0316600160a060020a0316815260200182815260200192505050600060405180830381600087803b15801561105d57600080fd5b505af1158015611071573d6000803e3d6000fd5b505050505b3d801561108e576020811461109857600091506110a4565b60001991506110a4565b60206000803e60005191505b5094935050505056fe546865207769746864726177207472616e73666572206d7573742073756363656564a165627a7a723058205ceef594be9c84b3e667a54d817a2e9af0162f9616f772241fdc6b89b322314d0029447574636845786368616e67652063616e2774206861766520616464726573732030";

    public static final String FUNC_ATLEASTZERO = "atleastZero";

    public static final String FUNC_BUYERBALANCES = "buyerBalances";

    public static final String FUNC_SAFETOADD = "safeToAdd";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_MIN = "min";

    public static final String FUNC_ETHTOKEN = "ethToken";

    public static final String FUNC_SUB = "sub";

    public static final String FUNC_SELLERBALANCES = "sellerBalances";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_MUL = "mul";

    public static final String FUNC_DX = "dx";

    public static final String FUNC_SAFETOMUL = "safeToMul";

    public static final String FUNC_SAFETOSUB = "safeToSub";

    public static final String FUNC_SELLETHER = "sellEther";

    public static final String FUNC_DEPOSITTOKEN = "depositToken";

    public static final String FUNC_DEPOSITETHER = "depositEther";

    public static final String FUNC_DEPOSITANDSELL = "depositAndSell";

    public static final String FUNC_POSTSELLORDER = "postSellOrder";

    public static final String FUNC_CLAIMSELLERFUNDS = "claimSellerFunds";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_ADDTOKENPAIR = "addTokenPair";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552479565429", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552472095368", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552477877832", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480989050", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480028214", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552479456813", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480528445", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552471101578", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480837624", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480097887", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552469879644", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480293309", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552481044336", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552472414983", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480390920", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480344273", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552470442877", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552471763422", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
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

    public RemoteCall<BigInteger> atleastZero(BigInteger a) {
        final Function function = new Function(FUNC_ATLEASTZERO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> buyerBalances(String param0, String param1, BigInteger param2, String param3) {
        final Function function = new Function(FUNC_BUYERBALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.Address(param3)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> safeToAdd(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SAFETOADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> add(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_ADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> min(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> ethToken() {
        final Function function = new Function(FUNC_ETHTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> sub(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> sellerBalances(String param0, String param1, BigInteger param2, String param3) {
        final Function function = new Function(FUNC_SELLERBALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.Address(param3)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balances(String param0, String param1) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> mul(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MUL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> dx() {
        final Function function = new Function(FUNC_DX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> safeToMul(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SAFETOMUL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> safeToSub(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SAFETOSUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteCall<TransactionReceipt> claimSellerFunds(String sellToken, String buyToken, String user, BigInteger auctionIndex) {
        final Function function = new Function(
                FUNC_CLAIMSELLERFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint256(auctionIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw(String tokenAddress, BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenAddress), 
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
