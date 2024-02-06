@devweb

Feature: To validate  Merchant feature
  @Background:
  Scenario Outline: ppaas home page
    Given The homepage <url>
    When I enter the email <email> on ppaas page and click on Continue button.
    When I enter the username <username> and password <password> on ppaas login page and click on Login button.
    Then The dashboard page will be displayed
    Examples:
      | url                                     | email                    | username | password      |
      | "https://admin-control.int.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |


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

