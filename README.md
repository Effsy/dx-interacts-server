# dx-interacts-server

## Setup Instructions

#### Setup ganache

Clone dxInteracts [contracts](https://github.com/Effsy/dx-interacts)

Install the dependencies

`> npm install`

Run your local ganache instance

`> ganache-cli -m "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat"`

Compile the contracts

`> truffle compile`

Deploy the contracts

`> truffle migrate`

#### Setup the server

Clone this repo

Install the dependencies

`> npm install`

Change all addresses of contracts marked `//CHANGE` in [server.js](https://github.com/Effsy/dx-interacts-server/blob/master/server.js) using the output from ganache console (use the final etherToken contract)

Note: In the future, this will read from the provider

Run the server

`> node server.js`


#### Send a test transaction

Go to 127.0.0.1:3000/testSend

Check the events in the console output
