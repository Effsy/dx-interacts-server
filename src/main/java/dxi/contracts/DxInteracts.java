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
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405160408061140b8339810180604052604081101561003057600080fd5b508051602090910151600160a060020a03811615156100b057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f54686520574554482061646472657373206d7573742062652076616c69640000604482015290519081900360640190fd5b600160a060020a0382161515610111576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806113e96022913960400191505060405180910390fd5b60038054600160a060020a03938416600160a060020a0319918216179091556004805492909316911617905561129d8061014c6000396000f3fe608060405260043610610152576000357c010000000000000000000000000000000000000000000000000000000090048063b67d77c5116100c8578063cb10fa761161008c578063cb10fa76146104d9578063d33128d214610509578063e31c71c414610576578063e9f8cd70146105a6578063f3fef3a3146105fd578063fd7065641461063657610152565b8063b67d77c5146103e0578063c1a21bf314610410578063c23f001f14610459578063c8a4ac9c14610494578063c9042b1e146104c457610152565b806365054e551161011a57806365054e55146102bb578063657a37ad14610304578063771602f7146103475780637ae2b5c7146103775780637bf1a627146103a757806398ea5fca146103d857610152565b80633069046814610157578063338b5dea1461019357806337775807146101cc5780634e30a66c1461021557806359f96ae514610259575b600080fd5b34801561016357600080fd5b506101816004803603602081101561017a57600080fd5b503561065c565b60408051918252519081900360200190f35b34801561019f57600080fd5b50610181600480360360408110156101b657600080fd5b50600160a060020a038135169060200135610676565b3480156101d857600080fd5b50610181600480360360808110156101ef57600080fd5b50600160a060020a038135811691602081013582169160408201359160600135166107c2565b34801561022157600080fd5b506102456004803603604081101561023857600080fd5b50803590602001356107ee565b604080519115158252519081900360200190f35b34801561026557600080fd5b506102a26004803603608081101561027c57600080fd5b50600160a060020a038135811691602081013590911690604081013590606001356107fb565b6040805192835260208301919091528051918290030190f35b3480156102c757600080fd5b506102a2600480360360808110156102de57600080fd5b50600160a060020a03813581169160208101358216916040820135169060600135610936565b34801561031057600080fd5b506102a26004803603606081101561032757600080fd5b50600160a060020a038135811691602081013590911690604001356109f2565b34801561035357600080fd5b506101816004803603604081101561036a57600080fd5b5080359060200135610aa0565b34801561038357600080fd5b506101816004803603604081101561039a57600080fd5b5080359060200135610abc565b3480156103b357600080fd5b506103bc610ad4565b60408051600160a060020a039092168252519081900360200190f35b610181610ae3565b3480156103ec57600080fd5b506101816004803603604081101561040357600080fd5b5080359060200135610bfb565b34801561041c57600080fd5b506101816004803603608081101561043357600080fd5b50600160a060020a03813581169160208101358216916040820135916060013516610c18565b34801561046557600080fd5b506101816004803603604081101561047c57600080fd5b50600160a060020a0381358116916020013516610c44565b3480156104a057600080fd5b50610181600480360360408110156104b757600080fd5b5080359060200135610c5e565b3480156104d057600080fd5b506103bc610c7a565b3480156104e557600080fd5b50610245600480360360408110156104fc57600080fd5b5080359060200135610c89565b34801561051557600080fd5b50610558600480360360a081101561052c57600080fd5b50600160a060020a03813581169160208101358216916040820135169060608101359060800135610cab565b60408051938452602084019290925282820152519081900360600190f35b34801561058257600080fd5b506102456004803603604081101561059957600080fd5b5080359060200135610e13565b3480156105b257600080fd5b506105fb600480360360c08110156105c957600080fd5b50600160a060020a03813581169160208101359091169060408101359060608101359060808101359060a00135610e18565b005b34801561060957600080fd5b506101816004803603604081101561062057600080fd5b50600160a060020a038135169060200135610ec3565b6102a26004803603602081101561064c57600080fd5b5035600160a060020a031661109d565b60008082121561066e57506000610671565b50805b919050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009285169163095ea7b391604480830192602092919082900301818787803b1580156106cf57600080fd5b505af11580156106e3573d6000803e3d6000fd5b505050506040513d60208110156106f957600080fd5b5050600354604080517f47e7ef24000000000000000000000000000000000000000000000000000000008152600160a060020a03868116600483015260248201869052915191909216916347e7ef249160448083019260209291908290030181600087803b15801561076a57600080fd5b505af115801561077e573d6000803e3d6000fd5b505050506040513d602081101561079457600080fd5b5051600160a060020a0390931660009081526020818152604080832033845290915290208390555090919050565b600260209081526000948552604080862082529385528385208152918452828420909152825290205481565b8082018211155b92915050565b600354604080517f59f96ae5000000000000000000000000000000000000000000000000000000008152600160a060020a03878116600483015286811660248301526044820186905260648201859052825160009485949216926359f96ae592608480830193919282900301818787803b15801561087857600080fd5b505af115801561088c573d6000803e3d6000fd5b505050506040513d60408110156108a257600080fd5b508051602091820151600160a060020a0389166000908152808452604080822033835290945292909220549093509091506108dd9084610bfb565b600160a060020a0396871660008181526020818152604080832033808552908352818420959095559282526001815282822098909916815296885280872095875294875284862090865290955291909220819055929050565b600354604080517f65054e55000000000000000000000000000000000000000000000000000000008152600160a060020a038781166004830152868116602483015230604483015260648201859052825160009485949216926365054e5592608480830193919282900301818787803b1580156109b257600080fd5b505af11580156109c6573d6000803e3d6000fd5b505050506040513d60408110156109dc57600080fd5b5080516020909101519097909650945050505050565b6003546040805160e060020a63095ea7b3028152600160a060020a03928316600482015260248101849052905160009283929087169163095ea7b39160448082019260209290919082900301818787803b158015610a4f57600080fd5b505af1158015610a63573d6000803e3d6000fd5b505050506040513d6020811015610a7957600080fd5b50610a8690508584610676565b50610a9485856000866107fb565b91509150935093915050565b6000610aac83836107ee565b1515610ab757600080fd5b500190565b600081831015610acd5750816107f5565b50806107f5565b600454600160a060020a031681565b60048054604080517fd0e30db00000000000000000000000000000000000000000000000000000000081529051600093600160a060020a039093169263d0e30db092349281830192879282900301818588803b158015610b4257600080fd5b505af1158015610b56573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b158015610bb457600080fd5b505af1158015610bc8573d6000803e3d6000fd5b505050506040513d6020811015610bde57600080fd5b5050600454610bf690600160a060020a031634610676565b905090565b6000610c078383610e13565b1515610c1257600080fd5b50900390565b600160209081526000948552604080862082529385528385208152918452828420909152825290205481565b600060208181529281526040808220909352908152205481565b6000610c6a8383610c89565b1515610c7557600080fd5b500290565b600354600160a060020a031681565b6000811580610ca457508282838502811515610ca157fe5b04145b9392505050565b600354604080517f06d58f2a000000000000000000000000000000000000000000000000000000008152600160a060020a0388811660048301528781166024830152868116604483015260648201869052608482018590529151600093849384939116916306d58f2a9160a48082019260609290919082900301818787803b158015610d3657600080fd5b505af1158015610d4a573d6000803e3d6000fd5b505050506040513d6060811015610d6057600080fd5b50805160208083015160409384015184517fa9059cbb000000000000000000000000000000000000000000000000000000008152600160a060020a038c81166004830152602482018b905295519498509196509450928a169263a9059cbb92604480830193928290030181600087803b158015610ddc57600080fd5b505af1158015610df0573d6000803e3d6000fd5b505050506040513d6020811015610e0657600080fd5b5050955095509592505050565b111590565b600354604080517fe9f8cd70000000000000000000000000000000000000000000000000000000008152600160a060020a038981166004830152888116602483015260448201889052606482018790526084820186905260a482018590529151919092169163e9f8cd709160c480830192600092919082900301818387803b158015610ea357600080fd5b505af1158015610eb7573d6000803e3d6000fd5b50505050505050505050565b600160a060020a038216600090815260208181526040808320338452909152812054610eef8382610abc565b925060008311610f4a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806112516021913960400191505060405180910390fd5b600354604080517ff3fef3a3000000000000000000000000000000000000000000000000000000008152600160a060020a038781166004830152602482018790529151919092169163f3fef3a39160448083019260209291908290030181600087803b158015610fb957600080fd5b505af1158015610fcd573d6000803e3d6000fd5b505050506040513d6020811015610fe357600080fd5b5051600160a060020a0385166000818152602081815260408083203380855290835281842086905581517fa9059cbb0000000000000000000000000000000000000000000000000000000081526004810191909152602481018990529051949650929363a9059cbb93604480820194918390030190829087803b15801561106957600080fd5b505af115801561107d573d6000803e3d6000fd5b505050506040513d602081101561109357600080fd5b5091949350505050565b600080600460009054906101000a9004600160a060020a0316600160a060020a031663d0e30db0346040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004016000604051808303818588803b15801561110c57600080fd5b505af1158015611120573d6000803e3d6000fd5b5050600480546003546040805160e060020a63095ea7b3028152600160a060020a0392831694810194909452346024850152519116945063095ea7b39350604480830193506020928290030181600087803b15801561117e57600080fd5b505af1158015611192573d6000803e3d6000fd5b505050506040513d60208110156111a857600080fd5b5051151561121757604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601960248201527f6661696c20746f20617070726f76652065746820746f6b656e00000000000000604482015290519081900360640190fd5b60045461122d90600160a060020a031634610676565b5060045461124790600160a060020a0316846000346107fb565b9150915091509156fe54686520616d6f756e74206d7573742062652067726561746572207468616e2030a165627a7a72305820f0e384a9da3f631164a92ffb55b647fdd1fc5f2faad19e7378cc3aa66ca2bd750029447574636845786368616e67652063616e2774206861766520616464726573732030";

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
        _addresses.put("1552432085118", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436622618", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552434000135", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552432281818", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552433892882", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552434291453", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552434622756", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436360346", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552431839618", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552431920139", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436479106", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552434357124", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552437292497", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436796942", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436006016", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552437055318", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552436980313", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
        _addresses.put("1552435802437", "0x4e71920b7330515faf5EA0c690f1aD06a85fB60c");
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
