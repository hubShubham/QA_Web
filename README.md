# Ppaas QA automation framework Web & API

QA Framework with RestAssured and Selenium based BDD

## Features

- [Maven](https://maven.apache.org/guides/) : Project dependency Management
- [Java](https://docs.oracle.com/en/java/) : Oriented object programming language
- [junit](https://docs.oracle.com/en/java/) : Test runner
- [Rest-Assured](https://rest-assured.io/) : Rest api verification library
- [Selenium](https://selenium.dev/) : Web Driver
- [Cucumber](https://cucumber.io/docs/cucumber/) : BDD/Gherkin framework
- [Allure report](https://docs.qameta.io/allure/) : Reporter

## Requirements

You will need this features installed :

- Java >= 11.x.x [how to install Java](https://java.com/en/download/)
- Maven >= x.x.x - [how to install NPM](https://maven.apache.org/install.html)
- IDE (Inttelij/Eclipse) - [How to install Intellij](https://www.jetbrains.com/help/idea/installation-guide.html)

## Project description

Java

    java/stepdefinitions - contains all classes for steps
    java/web/pages - contains pages classes(page object model)

Resources

    resources/features - contains all features files (write scenario test steps)
    resources/webdriver - contains all web drivers for cross browser

Properties

    ppass.dev.Properties - webdriver -> config the browser to use in test.

## Getting Started

### Install the dependencies:

To install dependencies, run the following Maven commands :

- Clean the maven repo
    ```bash
    mvn clean
    ```

- Install maven requirements
    ```bash
    mvn install
    ```

### Run tests

- To run all test scenarios, run the following Maven command :

    ```bash
    mvn test
    ```
- To run a specific test scenario, run the following maven command with tag cucumber option :

    ```bash
    mvn test -Dcucumber.options="--tags @ppaas"
   mvn clean test -D"cucumber.filter.tags=@smoke or @dev"
    ```
  Important Note: scenarios need to have the tag @ppas in order to be included in test executions
- To run test in a specific environment, you can pass environment variable from command line :
    ```bash
    mvn test -Denv="ppaas"
    ```
  The diffirent environment are defined in the properties files

- Run the tests in the CI The test are run in the CI after each deployment (merge in master) of payment services or
  after each modification in the test repo. Important Note: scenarios need to have the tag @ppas in order to be included
  in test executions The details of pipeline stages are in the file .gitlab-ci.yml

### Allure reports

You can generate a report using one of the following command:

     mvn allure:serve

Report will be generated to the directory `target/site/allure-maven/index.html`

You can run this command to generate the report and start a server on your machine and open report on the browser:

```bash
mvn allure:report
```
