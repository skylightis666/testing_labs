Feature: Various user interactions with the website

  @ex1
  Scenario: User logs in and edit checkboxes, radio and dropdown
    Given I open JDI GitHub site "https://jdi-testing.github.io/jdi-light/index.html"
    Given I log in with login: "Roman" and password: "Jdi1234"
    Then Browser title equals "Home Page"
    And Name is displayed and equals to "ROMAN IOVLEV"
    When I click on "Service" button in Header
    And I click on "DIFFERENT ELEMENTS" button in Service dropdown
    And I select "Water" checkboxes in main form on Different Elements page
    And I select "Wind" checkboxes in main form on Different Elements page
    And I select radio buttons "Selen" in main form on Different Elements page
    And I select "Yellow" in dropdown in main form on Different Elements page
    Then I see that part of logs in right section on Different Elements page
      | Colors: value changed to Yellow  |
      | metal: value changed to Selen    |
      | Wind: condition changed to true  |
      | Water: condition changed to true |

    @ex2
    Scenario: User Table Page test
      Given I open JDI GitHub site "https://jdi-testing.github.io/jdi-light/index.html"
      Given I log in with login: "Roman" and password: "Jdi1234"
      When I click on "Service" button in Header
      And I click on "USER TABLE" button in Service dropdown
      Then "User Table" page should be opened
      And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
      And 6 Usernames should be displayed on Users Table on User Table Page
      And 6 Description texts under images should be displayed on Users Table on User Table Page
      And 6 checkboxes should be displayed on Users Table on User Table Page
      And User table should contain following values:
        | Number | User             | Description                      |
        | 1      | Roman            | Wolverine                        |
        | 2      | Sergey Ivan      | Spider Man                       |
        | 3      | Vladzimir        | Punisher                         |
        | 4      | Helen Bennett    | Captain America\nsome description |
        | 5      | Yoshi Tannamuri  | Cyclope\nsome description         |
        | 6      | Giovanni Rovelli | Hulk\nsome description             |
      And droplist should contain values in column Type for user Roman
        | Dropdown Values |
        | Admin           |
        | User            |
        | Manager         |

    @ex3
    Scenario: User Table Page Vip checkbox test
      Given I open JDI GitHub site "https://jdi-testing.github.io/jdi-light/index.html"
      Given I log in with login: "Roman" and password: "Jdi1234"
      And I click on "Service" button in Header
      And I click on "USER TABLE" button in Service dropdown
      When I select 'vip' checkbox for "Sergey Ivan"
      Then 1 log row has "Vip: condition changed to true" text in log section
