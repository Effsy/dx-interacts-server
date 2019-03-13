# dx-interacts-server

## Setup Instructions

#### Setup ganache

Migrate the dxInteracts [contracts](https://github.com/Effsy/dx-interacts)

#### Setup the server

In order to generate MPT proofs, change the appropriate library access environment variable.

e.g. On linux:

`export LD_LIBRARY_PATH=<PATH_TO_DXINTERACTS_SERVER>/dx-interacts-server/src/main/resources`

See [JNA Getting Started](https://github.com/java-native-access/jna/blob/master/www/GettingStarted.md) for other operating systems.

Clone this repository

Build the server

`> ./gradlew build`

Run the server

`> ./gradlew run`

