@All
Feature: I want to verify user add delete feature

  @Adduser @Smoke
  Scenario Outline: Add user
    Given I am on webtables page
    When I clicked on Add user button
    And I fill user details FirstName "<FirstName>" LastName "<LastName>" UserName "<UserName>" Password "<Password>" Customer "<Customer>" Role "<Role>" Email "<Email>" Cell "<Cell>"
    And I click on save button
    Then I verified user FirstName "<FirstName>" with email "<Email>" is added

    Examples: 
      | FirstName | LastName | UserName    | Password | Customer    | Role       | Email          | Cell    |
      | Asef      | Padani   | Asef.padani |   123456 | Company AAA | Sales Team | test@gmail.com | 2001001 |

  @DeleteUser @Smoke
  Scenario: Delete User
    Given I am on webtables page
    When I delete user "novak" from list of users
    Then I verified user "novak" is deleted
