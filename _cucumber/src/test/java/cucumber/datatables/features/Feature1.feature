Feature: Feature cucumber data table and example


  Background: bg
    Given given condition
    Then  then condition

  @Test1
  Scenario: datatable

    Given given condition

    When  user use following list as column data
      | 1 |
      | 2 |
      | 3 |

    When  user use following list as row data
      | 1 | 2 | 3 | 4 | 5 |

    When  user use following list of list data
      | 1  | 2  | 3  | 4  | 5  |
      | 11 | 12 | 13 | 14 | 15 |
      | 21 | 22 | 23 | 24 | 25 |


  Scenario Outline: scenario outline example

    When  user use following map data
      | key1 | <a> |
      | key2 | <b> |
      | key3 | <c> |

    When  user use following list of maps data
      | key1 | key2 | key3 | key4 | key5 |
      | <a>  | <b>  | <c>  | 14   | 15   |
      | 21   | 22   | 23   | 24   | 25   |
      | 31   | 32   | 33   | 34   | 35   |

    Then  then condition

    Examples:
      | a | b  | c  |
      | 1 | 11 | 21 |
      | 2 | 12 | 22 |

