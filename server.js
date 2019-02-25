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
var myAddress = '0x30abac1cec520be49ac535f81860368f78077785'; //CHANGE
var toAddress = '0x5ffaa00c67230ef9424604e2e4abc58848d614cf';
var privateKey = '0x5409626185b407dfc268568ef4de76df3dd412a5c78baf45354554ab326541b7'; //CHANGE

const dutchXContractAddress = "0xB3e96188da9B4d928093aB5640F47085cda4ec67"; // proxy contract address //CHANGE
const dutchXContractABI = require('./dutchXabi.json'); // logic contract ABI
const dutchXContract = new web3js.eth.Contract(dutchXContractABI, dutchXContractAddress);

const owlContractAddress = '0x3C82f155a229365A04643d43F216A906a4A3537a'; // proxy contract address //CHANGE
const owlContractABI = require('./owlTokenabi.json');
const owlContract = new web3js.eth.Contract(owlContractABI, owlContractAddress);

const gnoContractAddress = '0xaD6279a07619b3B377240bf7Ef4bb5D45a7e6612'; //CHANGE
const gnoContractABI = require('./gnoTokenabi.json');
const gnoContract = new web3js.eth.Contract(gnoContractABI, gnoContractAddress);

const wethContractAddress = '0x255E92C885293E719041B9e5A8633F603C09b79A'; //CHANGE
const wethContractABI = require('./etherTokenabi.json');
const wethContract = new web3js.eth.Contract(wethContractABI, wethContractAddress);


app.get('/testSend', function (req, res) {

    // postSellOrder(address sellToken, address buyToken, uint auctionIndex, uint amount)

    // dutchXContract.methods.postSellOrder(owlContractAddress, gnoContractAddress, 0, 10).send({from: myAddress}, () => {
    //     console.log("sent");
    // });

    // TOOO: Integrate into send:
    // web3.utils.toWei('0.1', 'ether')

    wethContract.methods.deposit().send({from: myAddress, value: 100000000000000000})
        .on('transactionHash', (hash) => {
            console.log("Deposit successful! Transaction hash: " + hash);
        })
        .on('error', (error) => {
            console.log("error");
            console.log(error);
        });
});


app.get('/testTransfer', () => {
    wethContract.methods.transfer(toAddress, 1000000000).send({from: myAddress})
        .on('transactionHash', (hash) => {
            console.log("Deposit successful! Transaction hash: " + hash);
        })
        .on('error', (error) => {
            console.log("error");
            console.log(error);
        }).catch(err => {
            console.log(err)
    });
});


app.get('/testTransferFrom', () => {
    wethContract.methods.transferFrom().send({from: myAddress, to: toAddress, value: 10000000000})
        .on('transactionHash', (hash) => {
            console.log("Deposit successful! Transaction hash: " + hash);
        })
        .on('error', (error) => {
            console.log("error");
            console.log(error);
        }).catch(err => {
        console.log(err)
    });
});


app.listen(3000, () => {
    console.log('dxInteracts Server listening on port 3000!')

    // -------------
    // DUTCHX EVENTS
    // -------------

    dutchXContract.events.NewDeposit({}, (err, res) => {
        console.log("Filtering for new deposit");
        if (res) {
            console.log("New deposit added successfully")
            console.log(res)
        } else {
            console.log(err)
        }
    });

    dutchXContract.events.AuctionCleared({}, (err, res) => {
        console.log("Filtering for cleared auction");
        if (res) {
            console.log("Action Cleared successfully")
            console.log(res)
        } else {
            console.log(err)
        }

    });

    // Subscribe to NewSellOrder event
    dutchXContract.events.NewSellOrder({}, (err, res) => {
        console.log("Sell Order event received");
        if (err) {
            console.log("error");
            console.log(err);
        } else {
            console.log("SellOrder Succesfull - Event Received");
            console.log(res);
        }

        // Do something
    });

    // Subscribe to all events on DutchX Contract
    dutchXContract.events.allEvents({
        fromBlock: 0
    }, (err, res) => {
        if (err) {
            console.log("error");
            console.log(err);
        } else {
            console.log("New DutchX Event");
            console.log(res);
        }
    });

    // ------------------
    // ERC20 TOKEN EVENTS
    // ------------------

    // Subscribe to Transfer
    wethContract.events.Transfer({}, (err, res) => {
        console.log("Transfer received");
        if (err) {
            console.log("error");
            console.log(err);
        } else {
            console.log("WETH Transfer Succesfull - Event received");
            console.log(res);
        }

        // Do something
    });

    // Subscribe to Approval event
    wethContract.events.Approval({}, (err, res) => {
        console.log("Deposit received");
        if (err) {
            console.log("error");
            console.log(err);
        } else {
            console.log("WETH Deposit Succesfull - Event received");
            console.log(res);
        }

        // Do something
    });

    // Subscribe to Deposit event
    wethContract.events.Deposit({}, (err, res) => {
        console.log("Deposit received");
        if (err) {
            console.log("error");
            console.log(err);
        } else {
            console.log("WETH Deposit Succesfull - Event received");
            console.log(res);
        }

        // Do something
    });

    // Subscribe to all events on WETH contract
    wethContract.events.allEvents({
        fromBlock: 0
    }, (err, res) => {
        if (err) {
            console.log("error");
            console.log(err);
        } else {
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