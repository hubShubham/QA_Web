@devweb
  Feature: To validate  service Feature
	@Background:
	Scenario Outline: ppaas home page
		Given The homepage <url>
		When I enter the email <email> on ppaas page and click on Continue button.
		When I enter the username <username> and password <password> on ppaas login page and click on Login button.
		Then The dashboard page will be displayed
		Examples:
			| url                                  | email                    | username | password      |
			| "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |
##NON Device Application Service scenario

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
