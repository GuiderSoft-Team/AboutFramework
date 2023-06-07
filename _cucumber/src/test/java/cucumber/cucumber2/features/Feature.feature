Feature: feature ~pom

  Scenario: scenario def
    Given user on page "https://demoqa.com/text-box"
    When  user sendkeys "Tam adi" to "Full Name"
    And   user sendkeys "Eposta adresi" to "Email"
    And   user sendkeys "Mevcut Adres" to "Current Address"
    And   user sendkeys "Sabit adres" to "Permanent Address"


