truffleBuildDir="../dx-interacts/build/contracts"

targets="
DxInteracts
DutchExchange
TokenGNO
EtherToken
"

for target in ${targets}; do
    web3j truffle generate ${truffleBuildDir}/${target}.json -o ./src/main/java -p dxi.contracts 
done
