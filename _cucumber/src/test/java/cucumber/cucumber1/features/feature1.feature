Feature: Future Aciklamasi
  birden fazla satir olabilir

  Scenario: Scenario definition1

    Given user on homepage
    When  user search for "mac"
    Then  listed product count should be 4

  Scenario: Scenario definition2

    Given user on homepage
    When  user search for "mac"
    Then  listed product count should be 4
