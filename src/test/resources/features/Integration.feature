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

##MA

  Scenario Outline: To verify MA's package info page
    Given User is logged in already
    When  User clicks on Subscription & Configuration Menu and navigate to MA menu
    And   User  search for <MA_Name> and edits the MA
    And   User clicks on service Info tab
    And   User edits a service thorugh action button
    And   User  disables the service and clicks on ok
    And   Finally saves the MA
    Then  <MA_Name> gets updated successfully
    Examples:
      | packagename              | pricingGrid   | MA_Name  |
      | "PPaaS Payment Services" | "Payment_FR1" | " Wrogn" |


##Mercahnt
  Scenario Outline: To verify Merchant page
    Given User already logged in on portal
    When  User navigates to the Merchant menu
    And   User search for the <ME_name> nad click search
    And   Edits the MErchant
    And   click on service info tab
    And   edits the service
    And   enable/disable the service
    And   save the changes
    Then  MA gets updated

    Examples:
      |  | ME_name          |
      |  | "Wrogn Merchant" |

    ##Package

  Scenario Outline: To verify add package feature
    Given User is logged in a lready
    When  User clicks  Service and catalog Menu and navigate to Package menu
    And   User clicks on add button
    And   User Enter the  <packageCode> <packageName>  <publishDate> <Region> <Country>
		#When I enter the username <username> and password <password> on ppaas login page and click on Login button.
    And   User clicks Next button on basic info page for package
    Then  User comes onto the List of services tab
    Examples:
      |  | packageCode | packageName                     | publishDate  | Region | Country  |
      |  | "P_2003"    | "PPaaS Payment Package-Auto 13" | "30-05-2022" | "EMEA" | "France" |

  Scenario Outline: To verify SAp info tab
    Given User is  on SAP info tab
    When  User enters <SAP professional fees>, <Descriptiomn>, <subscription Fees> <Description_subs>,<Service Usage Fee> <Description_Usage>
    And   User clicks on Next
    Then User moves to List of Services tab

    Examples:
      |SAP professional fees                 | Descriptiomn       |subscription Fees|Description_subs|Service Usage Fee|Description_Usage|
      |"1"| "2"            |          "12"                    |"45"|       "78"                  |   "456"          |

  Scenario Outline: To verify List of Services tab
    Given User is   on List of Services tab
    When  User selects <TenantServiceDomain> and <Service> for taht domain
    And   User clcks on Add to Package button
    Then  User clicks on save button to finally create the package

    Examples:
      | TenantServiceDomain|Service|
      |"DCC Enablement"| "DCC test"            |


##SERVICE

  Scenario Outline: To verify Service basic info
    Given Clicks onService catalog and package
    And   Clicks on Services menu
    When Click on create Servbice button
    And  User fills <name> <serviceDomain>, <provider>, <logo>
    And clicks on next
    Then Advanced tab is displayed.
    Examples:
      | name                | serviceDomain       | provider       | logo          |
      | "AutomationService" | "Device Management" | "Ingenico_TEM" | "logoService" |

  Scenario: Validate Next button on Advanced Tab
    Given User is on the Advanced tab
    When clicks on next
    Then USer comes on to the use case page


  Scenario: Validate Use case selection
    Given User is on USe case tab
    When clicks on use case checkbox
    And  clicks on next
    Then user moves onto the configuration tab



  Scenario: Validate Next button Config tab
    Given User is on config tab
    When clicks on next
    Then user moves onto the actiivation param tab  tab



  Scenario: Validate Next button Activation Parameter tab
    Given User is on activation parameter tab
    When clicks on next
    Then user moves onto the usage event  tab



  Scenario: Validate submit button for  service creation on usaeg event tab
    Given User is on usage event tab
    When clicks on Submit button
    Then user comes back to the service listing grid


    ##Issuer Program

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
    ##Dynamic Terminal Menu

  Scenario Outline: To verify  Dynamic Terminal Menu For General Menu Type
    Given  User is already logged onto the Admin portal with tenant admin
    When   User naviagtes to Dynamic Terminal Menu
    And    click on Add Dynamic Terminal Menu
    And    Fill fields on basic info <TenantName> <MerchantAggregator> <ModelType> <MenuType> <MenuName> <DisplayArea>
    And    User clicks on Next button and goes to Preview page
    And    Then saves the page.
    Then   Page gets saved and updated with new Json for Aggreagtor
    And    User downloads the signature schema to verify the updated changes.
    Examples:
      |TenantName            | MerchantAggregator  |ModelType       |MenuType        | MenuName    |DisplayArea|
      |"central tenant"      | "IDFC Bank"     |"Tetra" |"General"|   "Automation menu test 2"  |  "Custom" |


  Scenario Outline: To verify  Dynamic Terminal Menu For program specific  Menu Type
    Given  User is already logged onto the Admin portal with tenant admin
    When   User naviagtes to Dynamic Terminal Menu
    And    click on Add Dynamic Terminal Menu
    And    Fill fields on basic info <MerchantAggregator> <ModelType> <MenuType> <MenuName> <DisplayArea> <serviceDomain>, <Service>, <ServiceUsecSe> <configuration>
    And    User clicks on Next button and goes to Preview page
    And    Then saves the page.
    Then   Page gets saved and updated with new Json for Aggreagtor
    And    User downloads the signature schema to verify the updated changes.
    Examples:
      | MerchantAggregator | ModelType | MenuType           | MenuName                | DisplayArea | serviceDomain                | Service           | ServiceUsecSe | configuration |
      | "IDFC Bank"        | "Tetra"   | "Program Specific" | "Automation speicifc 1" | "Custom"    | "Bank card Payment Services" | "BAMBORA Service" | "MKE 1"       | "JCB"         |

