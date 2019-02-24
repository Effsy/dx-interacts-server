# dx-interacts-server

## Setup Instructions

First clone dxInteracts [contracts](https://github.com/Effsy/dx-interacts)

Compile contracts
`> truffle compile`
 
Run your local ganache instance
`> ganache-cli`

Deploy contracts
`> truffle migrate`

Clone this repo

`> npm install`

Change all addresses of contracts marked `//CHANGE` in [server.js](https://github.com/Effsy/dx-interacts-server/blob/master/server.js) according to output from ganache console
Note: In the future, this will read from the provider

Run server
`> node server.js`
