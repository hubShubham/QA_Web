@devweb
Feature: To validate  package Feature
  @Background:
  Scenario Outline: ppaas home page
    Given The homepage <url>
    When I enter the email <email> on ppaas page and click on Continue button.
    When I enter the username <username> and password <password> on ppaas login page and click on Login button.
    Then The dashboard page will be displayed
    Examples:
      | url                                  | email                    | username | password      |
      | "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |



  Scenario Outline: To verify  Issuer Program addition functionality
    Given  User is already logged onto the Admin portal with tenant
    When   User navigates to the Issuer program Menu
    And    Click on Add Issuer Program button
    And    Fill fields on basic info  <PaymentName>, <ProgramName>, <Type>, <status>
    And    User clicks on Next button on issuer basic info tab
    Then   User is  moved to Transaction schema tab.
    Examples:
      | PaymentName | ProgramName       | Type       | status   |
      | "Alipay"    | "AliPay Program " | "e-Wallet" | "Active" |


  Scenario Outline: To verify  transaction schema tab on issuer program
    Given  User is on the Transaction schema tab
    When   User selects <transactionType> and <transactionSchema>
    And    click on Add button
    Then   Transaction mapping gets added
    And    User clicks on Next button for trsnaction and moves onto Program configuration tab
    Examples:
      | transactionType | transactionSchema |
      | "Cancel"        | "Cancel Payment"  |


  Scenario Outline: To verify  program configuration and BIN range tabs
    Given  User is  program configuration tab
    When   suer clicks on Next button
    Then   On the BIN range tab user fills  <Name>, <start>, <end>, <Min>, <Max>, <PIN>
    And    User clicks on Next button on BIN range tab
    And    On preview tab clicks on save button
    Then   Issuer program gets saved.
    Examples:
      |Name            | start  | end     | Min  |Max|PIN|
      |"AutomatedRange"| "2000"   | "3000"| "10" |"20"| "12"|