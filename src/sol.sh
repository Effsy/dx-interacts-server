dxiTruffleOutputPath="../../dx-interacts/build/contracts/DxInteracts.json"
dxTruffleOutputPath="../../dx-interacts/build/contracts/DutchExchange.json"
gnoTruffleOutputPath="../../dx-interacts/build/contracts/TokenGNO.json"
web3j truffle generate $dxiTruffleOutputPath -o ./src/main/java -p dxi.server
web3j truffle generate $dxTruffleOutputPath -o ./src/main/java -p dxi.server
web3j truffle generate $gnoTruffleOutputPath -o ./src/main/java -p dxi.server