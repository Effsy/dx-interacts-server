# dx-interacts-server

## Setup Instructions

#### Setup ganache

Clone dxInteracts [contracts](https://github.com/Effsy/dx-interacts)

Compile the contracts

`> truffle compile`
 
Run your local ganache instance

`> ganache-cli`

Deploy the contracts

`> truffle migrate`

#### Setup the server

Clone this repo

Install dependencies

`> npm install`

Change all addresses of contracts marked `//CHANGE` in [server.js](https://github.com/Effsy/dx-interacts-server/blob/master/server.js) using the output from ganache console (use the final etherToken contract)

Note: In the future, this will read from the provider

Run the server

`> node server.js`


#### Send a test transaction

Go to 127.0.0.1:3000/testSend

Check the events in the console output
