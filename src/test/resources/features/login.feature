Feature: Login Test - The user should be able to login with valid credentials

  Background:  Got to the home page
    Given The user is on the login page

  @plt1
  Scenario: PLT 1

    When The user enters valid credentials
    Then The user verifies welcome miky


 # login test with parameter
  @plt2
  Scenario: PLT 3

    When The user logs in using "miky" and "Test1234"
    Then The user verifies welcome "miky"

  @plt3
  Scenario Outline: PLT 3
    When The user logs in using "<username>" and "<password>"
    Then The user verifies welcome "<username>"
    Examples:
      | username | password |
      | miky     | Test1234 |

  @plt4
  Scenario Outline: PLT 4
    When The user logs in using with credentials
      | username | <user>     |
      | password | <password> |
    Then The user verifies welcome "<user>"
    Examples:
      | user | password |
      | miky | Test1234 |



  # negative login test
  @nlt_1
  Scenario Outline: Negative login test

    When The user logs in using "<invalidUserName>" and "<invalidPassword>"
    Then Validate that warning message is "<message>"
    Examples:
      | invalidUserName | invalidPassword | message                                |
      | invalidUserName | Test1234        | User does not exist.                   |
      | miky            | Test123456      | Wrong password.                        |
      | invalidUserName | invalidUserName | User does not exist.                   |
      |                 | Test1234        | Please fill out Username and Password. |
      | miky            |                 | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |

