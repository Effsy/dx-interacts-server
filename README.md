# dx-interacts-server

## Setup Instructions

#### Setup ganache

Clone dxInteracts [contracts](https://github.com/Effsy/dx-interacts)

Compile contracts

`> truffle compile`
 
Run your local ganache instance

`> ganache-cli`

Deploy contracts

`> truffle migrate`

#### Setup the server

Clone this repo

Install dependencies

`> npm install`

Change all addresses of contracts marked `//CHANGE` in [server.js](https://github.com/Effsy/dx-interacts-server/blob/master/server.js) using the output from ganache console (use the final etherToken contract)

Note: In the future, this will read from the provider

Run the server

`> node server.js`
