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
