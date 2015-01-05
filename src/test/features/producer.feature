Feature: Person operation

  Scenario: Create a list of 100 persons
    Given I have a Stream with person supplier initialized
    When I call stream to create a list of 100 persons
    Then I have list with 100 persons

  Scenario: Create a list of persons with given names
    Given I have a list of users:
    | name | lastName |
    | John | Doe      |
    | Jan  | Kowalski |
    | Anna | Kowalska |
    When I get first user
    Then I get:
    | name | lastName |
    | John | Doe      |

  Scenario: Add user to empty list
    Given I have a list of users:
      | name | lastName |
    When I add new user with name "Anna" and lastName "Kowalska"
    Then I get:
      | name | lastName |
      | Anna | Kowalska |







