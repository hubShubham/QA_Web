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


