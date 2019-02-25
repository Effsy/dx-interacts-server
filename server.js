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
var myAddress = '0x90f8bf6a479f320ead074411a4b0e7944ea8c9c1'; //CHANGE
var toAddress = '0xffcf8fdee72ac11b5c542428b35eef5769c409f0';
var privateKey = '0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d'; //CHANGE

const dutchXContractAddress = "0xD86C8F0327494034F60e25074420BcCF560D5610"; // proxy contract address //CHANGE
const dutchXContractABI = require('./dutchXabi.json'); // logic contract ABI
const dutchXContract = new web3js.eth.Contract(dutchXContractABI, dutchXContractAddress);

const owlContractAddress = '0xA57B8a5584442B467b4689F1144D269d096A3daF'; // proxy contract address //CHANGE
const owlContractABI = require('./owlTokenabi.json');
const owlContract = new web3js.eth.Contract(owlContractABI, owlContractAddress);

const gnoContractAddress = '0x67B5656d60a809915323Bf2C40A8bEF15A152e3e'; //CHANGE
const gnoContractABI = require('./gnoTokenabi.json');
const gnoContract = new web3js.eth.Contract(gnoContractABI, gnoContractAddress);

const wethContractAddress = '0x9b1f7F645351AF3631a656421eD2e40f2802E6c0'; //CHANGE
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


app.get('/testApprove', () => {
    wethContract.methods.approve(myAddress, 1000000000).send({from: myAddress})
        .on('transactionHash', (hash) => {
            console.log("Approval successful! Transaction hash: " + hash);
        })
        .on('error', (error) => {
            console.log("error");
            console.log(error);
        }).catch(err => {
        console.log(err)
    });
});

app.get('/postSellOrder', () => {
    var auctionIndex = dutchXContract.methods.getAuctionIndex(owlContract, gnoContract);
    console.log("AuctionINDEX" + auctionIndex);

    dutchXContract.methods.postSellOrder(owlContractAddress, gnoContractAddress, 0, 1).send({from: myAddress})
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
    wethContract.methods.transferFrom(myAddress, toAddress, 1000000000000).send({from: myAddress})
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
            console.log("WETH Approval Succesfull - Event received");
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