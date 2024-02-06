@devweb

Feature: To validate  Device feature
  @Background:
  Scenario Outline: ppaas home page
    Given The homepage <url>
    When I enter the email <email> on ppaas page and click on Continue button.
    When I enter the username <username> and password <password> on ppaas login page and click on Login button.
    Then The dashboard page will be displayed
    Examples:
      | url                                  | email                    | username | password      |
      | "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |


  Scenario Outline: To verify Device  service enable and disable
    Given User is already logged in admin portal with tenant
    When  User navigates to Device
    And   User search for <Device> on Device menu
    And   user edits device.
    And   USer goes to service info tab
    And   User edits a service for device
    And   User enables or disables a service and click ok
    And   Finally saves the Device changes
    Then  Device gest updated.

    Examples:
      |Device     |
      |"10401005"  |

