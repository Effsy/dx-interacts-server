dxiDir="../../dx-interacts/build/contracts/"

dxiTruffleOutputPath=$dxiDir"DxInteracts.json"
dxTruffleOutputPath=$dxiDir"DutchExchange.json"
gnoTruffleOutputPath=$dxiDir"TokenGNO.json"

web3j truffle generate $dxiTruffleOutputPath -o ./src/main/java -p dxi.server
web3j truffle generate $dxTruffleOutputPath -o ./src/main/java -p dxi.server
web3j truffle generate $gnoTruffleOutputPath -o ./src/main/java -p dxi.server
