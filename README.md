# KlmPriceCalculator- Java Service

This project was generated with Java version 1.8.

`https://bitbucket.org/afklmdevnet/simple-travel-api-mock/src/master/`

Clone this repo and start the mock (on windows systems use the gradlew.bat file):

`./gradlew bootRun`

The mock server will up with 8080 port

## Development server

Clone this repo `https://github.com/mansrivas/klm-java-services.git` and start the server using Eclipse IDE/STS:

Navigate to `http://localhost:8081/`.

The app will automatically reload if you change any of the source files with help devtool dependency .

## Build

Run `mvn clean install` to build the project. The build artifacts will be stored in the `target/` directory.

Resource endpoints:
-------------------

**Retrieve a list of airports**:

`http://localhost:8081/airports`

Query params:

- size: the size of the result
- page: the page to be selected in the paged response
- term: A search term that searches through code, name and description.

**Retrieve a fare offer**:

`http://localhost:8081/fares/{origin_code}/{destination_code}`

Query params:

- currency: the requested resulting currency, supported ones are EUR and USD

Resource endpoints:
-------------------

application.properties file help to configure server port and end point URL
