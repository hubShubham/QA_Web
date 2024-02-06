@devweb
Feature: test ppaas
	@Background:
	Scenario Outline: ppaas home page
		Given The homepage <url>
		When I enter the email <email> on ppaas page and click on Continue button.
		When I enter the username <username> and password <password> on ppaas login page and click on Login button.
		Then The dashboard page will be displayed
		Examples:
			| url                                  | email                    | username | password      |
			| "https://admin-control.dev.ppaas.tech/" | "abc@central-tenant.com" | "admin"  | "@Admin12345" |