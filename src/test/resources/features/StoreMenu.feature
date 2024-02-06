@devweb

Feature: To validate  Store feature
  @Background:
  Scenario Outline: ppaas home page
    Given The homepage <url>
    When I enter the email <email> on ppaas page and click on Continue button.
    When I enter the username <username> and password <password> on ppaas login page and click on Login button.
    Then The dashboard page will be displayed
    Examples:
      | url                                  | email                    | username | password      |
      | "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |


  Scenario Outline: To verify Store service enable and disable
    Given User is already logged into the admin portal
    When  User navigates to the store menu
    And   User search for <Store_name> and click Search
    And   User edits store
    And   Moves to service info tab
    And   Edits service
    And   Enables or disables the service and click on ok
    And   Finally saves the Store changes
    Then  Store gets updated

    Examples:
      |Store_name     |
      |"IDFC Store Paris"  |

