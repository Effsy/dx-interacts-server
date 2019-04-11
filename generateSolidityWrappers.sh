truffleBuildDir="../dx-interacts/build/contracts"

targets="
DxInteracts
DxiClaimAuction
DutchExchange
TokenGNO
EtherToken
DxiTriggerPostSellOrder
EventEmitter
"

for target in ${targets}; do
    web3j truffle generate ${truffleBuildDir}/${target}.json -o ./src/main/java -p dxi.contracts 
done
