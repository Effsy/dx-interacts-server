truffleBuildDir="../dx-interacts/build/contracts"

targets="
DxInteracts
DxiClaimAndWithdraw
DutchExchange
TokenGNO
"

for target in ${targets}; do
    web3j truffle generate ${truffleBuildDir}/${target}.json -o ./src/main/java -p dxi.server 
done
