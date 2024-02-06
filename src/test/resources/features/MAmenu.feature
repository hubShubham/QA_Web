@devweb

  Feature: To validate  package Feature
    @Background:
    Scenario Outline: ppaas home page
      Given The homepage <url>
      When I enter the email <email> on ppaas page and click on Continue button.
      When I enter the username <username> and password <password> on ppaas login page and click on Login button.
      Then The dashboard page will be displayed

      Examples:
     ##   | url                                  | email                    | username | password      |
       ## | "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin" | "@Admin12345" |

        | url                                     | email                    | username | password      |
        | "https://admin-control.int.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |

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

