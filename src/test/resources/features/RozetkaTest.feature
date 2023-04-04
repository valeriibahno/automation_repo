Feature: Testing web-site Rozetka

  Background: Open web-site Rozetka
    Given Open web-site Rozetka

  Scenario: Searching several brands on Rozetka
    When I search several brands of laptop
      | HP    |
      | Acer  |
      | Apple |
    Then I see quantity of selected brands of laptop
      |  3  |

  Scenario Outline: Searching brand on Rozetka
    When I search only one <brand>
    Then Verify title of result as <brand>

    Examples:
      | brand   |
      | Nokia   |
      | Poco    |
      | Realme  |

  Scenario Outline: Login with wrong email
    When Login with wrong <email>
    Then I see error message with invalid email

    Examples:
      | email     |
      | test1234  |
      | 12345     |
      | !6789076  |
      | ASFD56FFD |
      | _te#st    |
      | t$Ap est  |

    Scenario: Login with correct email and wrong password
      When Login with correct email and wrong password
      Then I see error message with invalid password

    Scenario: Search delivery points
        When Open delivery points
        Then I filtered delivery points by city
          | Дніпро  |
          | Житомир |
          | Львів   |

    Scenario: Search vacancies
      When I open page with vacancies
      Then I see list of vacancies