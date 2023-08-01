Feature: Login Test - The user should be able to login with valid credentials

  @plt1
  Scenario: PLT 1
    Given The user is on the login page
    When The user enters valid credentials
    Then The user verifies welcome miky


 # login test with parameter
  @plt2_parameter
  Scenario: Login with parameter
    Given The user is on the login page
    When The user logs in using "miky" and "Test1234"
    Then The user verifies welcome miky

  # negative login test
  @plt3_negative
  Scenario Outline: Negative login test
    Given The user is on the login page
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

