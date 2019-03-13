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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516040806114498339810180604052604081101561003057600080fd5b508051602090910151600160a060020a03811615156100b057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f54686520574554482061646472657373206d7573742062652076616c69640000604482015290519081900360640190fd5b600160a060020a0382161515610111576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806114276022913960400191505060405180910390fd5b60038054600160a060020a03938416600160a060020a031991821617909155600480549290931691161790556112db8061014c6000396000f3fe6080604052600436106101395760003560e060020a90048063b67d77c5116100af578063cb10fa7611610073578063cb10fa76146104c0578063d33128d2146104f0578063e31c71c41461055d578063e9f8cd701461058d578063f3fef3a3146105e4578063fd7065641461061d57610139565b8063b67d77c5146103c7578063c1a21bf3146103f7578063c23f001f14610440578063c8a4ac9c1461047b578063c9042b1e146104ab57610139565b806365054e551161010157806365054e55146102a2578063657a37ad146102eb578063771602f71461032e5780637ae2b5c71461035e5780637bf1a6271461038e57806398ea5fca146103bf57610139565b8063306904681461013e578063338b5dea1461017a57806337775807146101b35780634e30a66c146101fc57806359f96ae514610240575b600080fd5b34801561014a57600080fd5b506101686004803603602081101561016157600080fd5b5035610643565b60408051918252519081900360200190f35b34801561018657600080fd5b506101686004803603604081101561019d57600080fd5b50600160a060020a03813516906020013561065d565b3480156101bf57600080fd5b50610168600480360360808110156101d657600080fd5b50600160a060020a038135811691602081013582169160408201359160600135166107a9565b34801561020857600080fd5b5061022c6004803603604081101561021f57600080fd5b50803590602001356107d5565b604080519115158252519081900360200190f35b34801561024c57600080fd5b506102896004803603608081101561026357600080fd5b50600160a060020a038135811691602081013590911690604081013590606001356107e2565b6040805192835260208301919091528051918290030190f35b3480156102ae57600080fd5b50610289600480360360808110156102c557600080fd5b50600160a060020a0381358116916020810135821691604082013516906060013561091d565b3480156102f757600080fd5b506102896004803603606081101561030e57600080fd5b50600160a060020a038135811691602081013590911690604001356109d9565b34801561033a57600080fd5b506101686004803603604081101561035157600080fd5b5080359060200135610a87565b34801561036a57600080fd5b506101686004803603604081101561038157600080fd5b5080359060200135610aa3565b34801561039a57600080fd5b506103a3610abb565b60408051600160a060020a039092168252519081900360200190f35b610168610aca565b3480156103d357600080fd5b50610168600480360360408110156103ea57600080fd5b5080359060200135610be2565b34801561040357600080fd5b506101686004803603608081101561041a57600080fd5b50600160a060020a03813581169160208101358216916040820135916060013516610bff565b34801561044c57600080fd5b506101686004803603604081101561046357600080fd5b50600160a060020a0381358116916020013516610c2b565b34801561048757600080fd5b506101686004803603604081101561049e57600080fd5b5080359060200135610c45565b3480156104b757600080fd5b506103a3610c61565b3480156104cc57600080fd5b5061022c600480360360408110156104e357600080fd5b5080359060200135610c70565b3480156104fc57600080fd5b5061053f600480360360a081101561051357600080fd5b50600160a060020a03813581169160208101358216916040820135169060608101359060800135610c92565b60408051938452602084019290925282820152519081900360600190f35b34801561056957600080fd5b5061022c6004803603604081101561058057600080fd5b5080359060200135610dfa565b34801561059957600080fd5b506105e2600480360360c08110156105b057600080fd5b50600160a060020a03813581169160208101359091169060408101359060608101359060808101359060a00135610dff565b005b3480156105f057600080fd5b506101686004803603604081101561060757600080fd5b50600160a060020a038135169060200135610eaa565b6102896004803603602081101561063357600080fd5b5035600160a060020a0316610fae565b60008082121561065557506000610658565b50805b919050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009285169163095ea7b391604480830192602092919082900301818787803b1580156106b657600080fd5b505af11580156106ca573d6000803e3d6000fd5b505050506040513d60208110156106e057600080fd5b5050600354604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a03868116600483015260248201869052915191909216916347e7ef249160448083019260209291908290030181600087803b15801561075157600080fd5b505af1158015610765573d6000803e3d6000fd5b505050506040513d602081101561077b57600080fd5b5051600160a060020a0390931660009081526020818152604080832033845290915290208390555090919050565b600260209081526000948552604080862082529385528385208152918452828420909152825290205481565b8082018211155b92915050565b600354604080517f59f96ae5000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483015286811660248301526044820186905260648201859052825160009485949216926359f96ae592608480830193919282900301818787803b15801561085f57600080fd5b505af1158015610873573d6000803e3d6000fd5b505050506040513d604081101561088957600080fd5b508051602091820151600160a060020a0389166000908152808452604080822033835290945292909220549093509091506108c49084610be2565b600160a060020a0396871660008181526020818152604080832033808552908352818420959095559282526001815282822098909916815296885280872095875294875284862090865290955291909220819055929050565b600354604080517f65054e55000000000000000000000000000000000000000000000000000000008152600160a060020a038781166004830152868116602483015230604483015260648201859052825160009485949216926365054e5592608480830193919282900301818787803b15801561099957600080fd5b505af11580156109ad573d6000803e3d6000fd5b505050506040513d60408110156109c357600080fd5b5080516020909101519097909650945050505050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009283929087169163095ea7b39160448082019260209290919082900301818787803b158015610a3657600080fd5b505af1158015610a4a573d6000803e3d6000fd5b505050506040513d6020811015610a6057600080fd5b50610a6d9050858461065d565b50610a7b85856000866107e2565b91509150935093915050565b6000610a9383836107d5565b1515610a9e57600080fd5b500190565b600081831015610ab45750816107dc565b50806107dc565b600454600160a060020a031681565b60048054604080517fd0e30db00000000000000000000000000000000000000000000000000000000081529051600093600160a060020a039093169263d0e30db092349281830192879282900301818588803b158015610b2957600080fd5b505af1158015610b3d573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b158015610b9b57600080fd5b505af1158015610baf573d6000803e3d6000fd5b505050506040513d6020811015610bc557600080fd5b5050600454610bdd90600160a060020a03163461065d565b905090565b6000610bee8383610dfa565b1515610bf957600080fd5b50900390565b600160209081526000948552604080862082529385528385208152918452828420909152825290205481565b600060208181529281526040808220909352908152205481565b6000610c518383610c70565b1515610c5c57600080fd5b500290565b600354600160a060020a031681565b6000811580610c8b57508282838502811515610c8857fe5b04145b9392505050565b600354604080517f06d58f2a000000000000000000000000000000000000000000000000000000008152600160a060020a0388811660048301528781166024830152868116604483015260648201869052608482018590529151600093849384939116916306d58f2a9160a48082019260609290919082900301818787803b158015610d1d57600080fd5b505af1158015610d31573d6000803e3d6000fd5b505050506040513d6060811015610d4757600080fd5b50805160208083015160409384015184517fa9059cbb000000000000000000000000000000000000000000000000000000008152600160a060020a038c81166004830152602482018b905295519498509196509450928a169263a9059cbb92604480830193928290030181600087803b158015610dc357600080fd5b505af1158015610dd7573d6000803e3d6000fd5b505050506040513d6020811015610ded57600080fd5b5050955095509592505050565b111590565b600354604080517fe9f8cd70000000000000000000000000000000000000000000000000000000008152600160a060020a038981166004830152888116602483015260448201889052606482018790526084820186905260a482018590529151919092169163e9f8cd709160c480830192600092919082900301818387803b158015610e8a57600080fd5b505af1158015610e9e573d6000803e3d6000fd5b50505050505050505050565b600354604080517ff3fef3a3000000000000000000000000000000000000000000000000000000008152600160a060020a038581166004830152602482018590529151600093929092169163f3fef3a39160448082019260209290919082900301818787803b158015610f1c57600080fd5b505af1158015610f30573d6000803e3d6000fd5b505050506040513d6020811015610f4657600080fd5b50519050610f578333846000611148565b15156107dc576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602281526020018061128e6022913960400191505060405180910390fd5b600080600460009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff1660e060020a0281526004016000604051808303818588803b15801561100457600080fd5b505af1158015611018573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b15801561107657600080fd5b505af115801561108a573d6000803e3d6000fd5b505050506040513d60208110156110a057600080fd5b5051151561110f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f6661696c20746f20617070726f76652065746820746f6b656e00000000000000604482015290519081900360640190fd5b60045461112590600160a060020a03163461065d565b5060045461113f90600160a060020a0316846000346107e2565b91509150915091565b600081156111da57604080517f23b872dd000000000000000000000000000000000000000000000000000000008152336004820152306024820152604481018590529051600160a060020a038716916323b872dd91606480830192600092919082900301818387803b1580156111bd57600080fd5b505af11580156111d1573d6000803e3d6000fd5b50505050611256565b84600160a060020a031663a9059cbb85856040518363ffffffff1660e060020a0281526004018083600160a060020a0316600160a060020a0316815260200182815260200192505050600060405180830381600087803b15801561123d57600080fd5b505af1158015611251573d6000803e3d6000fd5b505050505b3d801561126e57602081146112785760009150611284565b6000199150611284565b60206000803e60005191505b5094935050505056fe546865207769746864726177207472616e73666572206d7573742073756363656564a165627a7a723058202fbd9e99dcaf0d8a670fb54cf7299b0a7ebea4a6e0b7bd62e70706a1d8aa82da0029447574636845786368616e67652063616e2774206861766520616464726573732030";

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

    public static final String FUNC_CLAIMAUCTION = "claimAuction";

    public static final String FUNC_ADDTOKENPAIR = "addTokenPair";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1552479565429", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552472095368", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552477877832", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480028214", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552479456813", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480528445", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552471101578", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480837624", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480097887", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552469879644", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552480293309", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
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
