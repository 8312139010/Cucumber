Feature: Managing user in the pet store

  Background: user test management

  Scenario: Create a user and login with right user name and password
    Given create a user with id 1280
    Then i login the user with correct user name "qasim" and password "kashmir"

  Scenario: Create a user and login with wrong user name and password
    Given create a user with id 1280
    Then i login the user with wrong user name "asim" and password "pakistan"

  Scenario: Create many users login them and delete them
    Given create a user with id 1280
    Given create a user with id 1281
    Then i login the user with correct user name "qasim" and password "kashmir"
    Then i login the user with correct user name "asim" and password "pakistan"
    When i delete the user with username "qasim"
    Then i get en error fetching the user with username "qasim"

    Scenario: create a user update email and get the user
      Given create a user with id 1280
      When update the email of user with username "qasim"
      Then validate the username "qasim" if changes has been made



