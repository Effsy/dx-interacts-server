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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516040806114608339810180604052604081101561003057600080fd5b508051602090910151600160a060020a03811615156100b057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f54686520574554482061646472657373206d7573742062652076616c69640000604482015290519081900360640190fd5b600160a060020a0382161515610111576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602281526020018061143e6022913960400191505060405180910390fd5b60038054600160a060020a03938416600160a060020a031991821617909155600480549290931691161790556112f28061014c6000396000f3fe60806040526004361061012e5760003560e060020a90048063b67d77c5116100af578063c9042b1e11610073578063c9042b1e146104b8578063cb10fa76146104cd578063e31c71c4146104fd578063e9f8cd701461052d578063f3fef3a314610584578063fd706564146105bd5761012e565b8063b67d77c514610391578063bed9f814146103c1578063c1a21bf314610404578063c23f001f1461044d578063c8a4ac9c146104885761012e565b8063657a37ad116100f6578063657a37ad14610297578063771602f7146102f85780637ae2b5c7146103285780637bf1a6271461035857806398ea5fca146103895761012e565b80633069046814610133578063338b5dea1461016f57806337775807146101a85780634e30a66c146101f157806359f96ae514610235575b600080fd5b34801561013f57600080fd5b5061015d6004803603602081101561015657600080fd5b50356105e3565b60408051918252519081900360200190f35b34801561017b57600080fd5b5061015d6004803603604081101561019257600080fd5b50600160a060020a0381351690602001356105fd565b3480156101b457600080fd5b5061015d600480360360808110156101cb57600080fd5b50600160a060020a03813581169160208101358216916040820135916060013516610613565b3480156101fd57600080fd5b506102216004803603604081101561021457600080fd5b508035906020013561063f565b604080519115158252519081900360200190f35b34801561024157600080fd5b5061027e6004803603608081101561025857600080fd5b50600160a060020a03813581169160208101359091169060408101359060600135610646565b6040805192835260208301919091528051918290030190f35b3480156102a357600080fd5b506102da600480360360608110156102ba57600080fd5b50600160a060020a03813581169160208101359091169060400135610663565b60408051938452602084019290925282820152519081900360600190f35b34801561030457600080fd5b5061015d6004803603604081101561031b57600080fd5b5080359060200135610719565b34801561033457600080fd5b5061015d6004803603604081101561034b57600080fd5b5080359060200135610735565b34801561036457600080fd5b5061036d61074d565b60408051600160a060020a039092168252519081900360200190f35b61015d61075c565b34801561039d57600080fd5b5061015d600480360360408110156103b457600080fd5b5080359060200135610875565b3480156103cd57600080fd5b5061027e600480360360608110156103e457600080fd5b50600160a060020a03813581169160208101359091169060400135610892565b34801561041057600080fd5b5061015d6004803603608081101561042757600080fd5b50600160a060020a038135811691602081013582169160408201359160600135166108ad565b34801561045957600080fd5b5061015d6004803603604081101561047057600080fd5b50600160a060020a03813581169160200135166108d9565b34801561049457600080fd5b5061015d600480360360408110156104ab57600080fd5b50803590602001356108f3565b3480156104c457600080fd5b5061036d61090f565b3480156104d957600080fd5b50610221600480360360408110156104f057600080fd5b508035906020013561091e565b34801561050957600080fd5b506102216004803603604081101561052057600080fd5b508035906020013561093f565b34801561053957600080fd5b50610582600480360360c081101561055057600080fd5b50600160a060020a03813581169160208101359091169060408101359060608101359060808101359060a00135610944565b005b34801561059057600080fd5b5061015d600480360360408110156105a757600080fd5b50600160a060020a0381351690602001356109ef565b6102da600480360360208110156105d357600080fd5b5035600160a060020a03166109fc565b6000808212156105f5575060006105f8565b50805b919050565b600061060a838333610b9d565b90505b92915050565b600260209081526000948552604080862082529385528385208152918452828420909152825290205481565b8101101590565b6000806106568686868633610cef565b9150915094509492505050565b6003546040805160e060020a63095ea7b3028152600160a060020a039283166004820152602481018490529051600092839283929188169163095ea7b39160448082019260209290919082900301818787803b1580156106c257600080fd5b505af11580156106d6573d6000803e3d6000fd5b505050506040513d60208110156106ec57600080fd5b506106fa9050868533610b9d565b925061070a868660008733610cef565b93979096509294509192505050565b6000610725838361063f565b151561073057600080fd5b500190565b60008183101561074657508161060d565b508061060d565b600454600160a060020a031681565b60048054604080517fd0e30db00000000000000000000000000000000000000000000000000000000081529051600093600160a060020a039093169263d0e30db092349281830192879282900301818588803b1580156107bb57600080fd5b505af11580156107cf573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b15801561082d57600080fd5b505af1158015610841573d6000803e3d6000fd5b505050506040513d602081101561085757600080fd5b505060045461087090600160a060020a03163433610b9d565b905090565b6000610881838361093f565b151561088c57600080fd5b50900390565b6000806108a185858533610e31565b91509150935093915050565b600160209081526000948552604080862082529385528385208152918452828420909152825290205481565b600060208181529281526040808220909352908152205481565b60006108ff838361091e565b151561090a57600080fd5b500290565b600354600160a060020a031681565b600081158061060a5750828283850281151561093657fe5b04149392505050565b111590565b600354604080517fe9f8cd70000000000000000000000000000000000000000000000000000000008152600160a060020a038981166004830152888116602483015260448201889052606482018790526084820186905260a482018590529151919092169163e9f8cd709160c480830192600092919082900301818387803b1580156109cf57600080fd5b505af11580156109e3573d6000803e3d6000fd5b50505050505050505050565b600061060a838333610f7c565b6000806000600460009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff1660e060020a0281526004016000604051808303818588803b158015610a5457600080fd5b505af1158015610a68573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b158015610ac657600080fd5b505af1158015610ada573d6000803e3d6000fd5b505050506040513d6020811015610af057600080fd5b50511515610b5f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f6661696c20746f20617070726f76652065746820746f6b656e00000000000000604482015290519081900360640190fd5b600454610b7690600160a060020a03163433610b9d565b600454909350610b9390600160a060020a03168560003433610cef565b9395909450915050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101859052905160009286169163095ea7b391604480830192602092919082900301818787803b158015610bf657600080fd5b505af1158015610c0a573d6000803e3d6000fd5b505050506040513d6020811015610c2057600080fd5b5050600354604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483015260248201879052915191909216916347e7ef249160448083019260209291908290030181600087803b158015610c9157600080fd5b505af1158015610ca5573d6000803e3d6000fd5b505050506040513d6020811015610cbb57600080fd5b5051600160a060020a0394851660009081526020818152604080832095909716825293909352939091208390555090919050565b600354604080517f59f96ae5000000000000000000000000000000000000000000000000000000008152600160a060020a03888116600483015287811660248301526044820187905260648201869052825160009485949216926359f96ae592608480830193919282900301818787803b158015610d6c57600080fd5b505af1158015610d80573d6000803e3d6000fd5b505050506040513d6040811015610d9657600080fd5b508051602091820151600160a060020a03808b1660009081528085526040808220928916825291909452909220549193509150610dd39085610875565b600160a060020a03978816600081815260208181526040808320978c16808452978252808320949094559181526001825282812098909916895296875280882095885294865284872092875291909452919093208290559092909150565b600160a060020a0380851660008181526001602090815260408083208886168085529083528184208885528352818420878716855290925280832083905560035481517f65054e5500000000000000000000000000000000000000000000000000000000815260048101959095526024850192909252306044850152606484018790528051929485949216926365054e5592608480820193929182900301818787803b158015610ee057600080fd5b505af1158015610ef4573d6000803e3d6000fd5b505050506040513d6040811015610f0a57600080fd5b508051602091820151600160a060020a038089166000908152808552604080822092891682529190945290922054909350909150610f489083610719565b600160a060020a03958616600090815260208181526040808320969098168252949094529490922093909355919391925050565b600160a060020a0380841660009081526020818152604080832093851683529290529081205480841115610ffb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806112756030913960400191505060405180910390fd5b600354604080517ff3fef3a3000000000000000000000000000000000000000000000000000000008152600160a060020a038881166004830152602482018890529151919092169163f3fef3a39160448083019260209291908290030181600087803b15801561106a57600080fd5b505af115801561107e573d6000803e3d6000fd5b505050506040513d602081101561109457600080fd5b5051600160a060020a0380871660009081526020818152604080832093881683529290529081208290559092506110d09086908590879061112f565b1515611127576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806112a56022913960400191505060405180910390fd5b509392505050565b600081156111c157604080517f23b872dd000000000000000000000000000000000000000000000000000000008152336004820152306024820152604481018590529051600160a060020a038716916323b872dd91606480830192600092919082900301818387803b1580156111a457600080fd5b505af11580156111b8573d6000803e3d6000fd5b5050505061123d565b84600160a060020a031663a9059cbb85856040518363ffffffff1660e060020a0281526004018083600160a060020a0316600160a060020a0316815260200182815260200192505050600060405180830381600087803b15801561122457600080fd5b505af1158015611238573d6000803e3d6000fd5b505050505b3d8015611255576020811461125f576000915061126b565b600019915061126b565b60206000803e60005191505b5094935050505056fe54686520757365722062616c616e6365206d7573742062652067726561746572207468616e2074686520616d6f756e74546865207769746864726177207472616e73666572206d7573742073756363656564a165627a7a72305820e8a9d4f55772e67fcb3d8f2c650c24e9e919a5556e23bc8e1a8e575448e57fcb0029447574636845786368616e67652063616e2774206861766520616464726573732030";

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
        _addresses.put("1552814774039", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552811139389", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812295727", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812818415", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552813091280", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552814441272", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552814149250", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812478568", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552813023381", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552810518256", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812045585", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812758659", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552811672104", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552814294046", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552810808550", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812364465", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552812663632", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552813502130", "0xdE5491f774F0Cb009ABcEA7326342E105dbb1B2E");
        _addresses.put("1552815537743", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552811439152", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
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

    public RemoteCall<TransactionReceipt> claimSellerFunds(String sellToken, String buyToken, BigInteger auctionIndex) {
        final Function function = new Function(
                FUNC_CLAIMSELLERFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sellToken), 
                new org.web3j.abi.datatypes.Address(buyToken), 
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
