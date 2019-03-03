const web3 = require('web3');
const express = require('express');

const app = express();

//Web3 Provider Endpoint
//web3js = new web3(new web3.providers.HttpProvider("https://rinkeby.infura.io/852c355d07b648b4b3374e427f9fd9aa"));
//var myAddress = '0xfBb4595197C50FA0d0B3B2FE47074a46a82E6768';
//var privateKey = 'BBF40AC1D3D4F123E824713906858006278B9A0F75001F84A8682A145F43C62B';
//var privateKey = Buffer.from('BBF40AC1D3D4F123E824713906858006278B9A0F75001F84A8682A145F43C62B', 'hex')

// Local Provider
web3js = new web3(new web3.providers.WebsocketProvider("http://127.0.0.1:8545"));
var myAddress = '0x627306090abab3a6e1400e9345bc60c78a8bef57'; //CHANGE
var privateKey = '0xc87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3'; //CHANGE

const dutchXContractAddress = "0x2a504B5e7eC284ACa5b6f49716611237239F0b97"; // proxy contract address //CHANGE
const dutchXContractABI = require('./dutchXabi.json'); // logic contract ABI
const dutchXContract = new web3js.eth.Contract(dutchXContractABI, dutchXContractAddress);

const owlContractAddress = '0xdDA6327139485221633A1FcD65f4aC932E60A2e1'; // proxy contract address //CHANGE
// const owlContractABI = require('./.json');
// const owlContract = new web3js.eth.Contract(owlContractABI, owlContractAddress);

const gnoContractAddress = '0x75c35C980C0d37ef46DF04d31A140b65503c0eEd'; //CHANGE
// const gnoContractABI = require('./.json');
// const gnoContract = new web3js.eth.Contract(gnoContractABI, gnoContractAddress);

const wethContractAddress = '0xf204a4Ef082f5c04bB89F7D5E6568B796096735a'; //CHANGE
const wethContractABI = require('./etherTokenabi.json');
const wethContract = new web3js.eth.Contract(wethContractABI, wethContractAddress);



app.get('/testSend',function(req,res){

    // postSellOrder(address sellToken, address buyToken, uint auctionIndex, uint amount)

    // dutchXContract.methods.postSellOrder(owlContractAddress, gnoContractAddress, 0, 10).send({from: myAddress}, () => {
    //     console.log("sent");
    // });
    
    // TOOO: Integrate into send:
    // web3.utils.toWei('0.1', 'ether')

    wethContract.methods.deposit().send({from: myAddress, value: 100000000000000000})
    .on('transactionHash', (hash)=> {
        console.log("Deposit successful! Transaction hash: " + hash);
    })
    .on('error', (error)=> {
        console.log("error");
        console.log(error);
    });
    
});

app.listen(3000, () => {
    console.log('dxInteracts Server listening on port 3000!')
    
    // -------------
    // DUTCHX EVENTS
    // -------------
    
    // Subscribe to NewSellOrder event
    dutchXContract.events.NewSellOrder({}, (err, res) => {
        console.log("Sell Order event received");
        if (err) {
            console.log("error");
            console.log(err);
        }
        else {
            console.log("SellOrder Succesfull - Event Received");
            console.log(res);
        }
        
        // Do something
    });

    // Subscribe to all events on DutchX Contract
    dutchXContract.events.allEvents({
        fromBlock: 0}, (err, res) => {
        if (err) {
            console.log("error");
            console.log(err);
        }
        else {
            console.log("New DutchX Event");
            console.log(res);
        }
    });

    // ------------------
    // ERC20 TOKEN EVENTS
    // ------------------

    // Subscribe to Deposit event
    wethContract.events.Deposit({}, (err, res) => {
        console.log("Deposit received");
        if (err) {
            console.log("error");
            console.log(err);
        }
        else {
            console.log("WETH Deposit Succesfull - Event received");
            console.log(res);
        }
        
        // Do something
    });

    // Subscribe to all events on WETH contract
    wethContract.events.allEvents({
        fromBlock: 0}, (err, res) => {
        if (err) {
            console.log("error");
            console.log(err);
        }
        else {
            console.log("New WETH Event");
            console.log(res);
        }
    });

});

/**
 * EVENTS
 * 
 * -- Events to listen for on ERC20 tokens:
 * Transfer(address indexed from, address indexed to, uint tokens)
 * Approval(address indexed tokenOwner, address indexed spender, uint tokens)
 * 
 * 
 * -- Events to listen for on DutchX:
 * NewDeposit(address indexed token, uint amount)
 * NewSellOrder(
        address indexed sellToken,
        address indexed buyToken,
        address indexed user,
        uint auctionIndex,
        uint amount
    )
 * AuctionCleared(
        address indexed sellToken,
        address indexed buyToken,
        uint sellVolume,
        uint buyVolume,
        uint indexed auctionIndex
    )
 */