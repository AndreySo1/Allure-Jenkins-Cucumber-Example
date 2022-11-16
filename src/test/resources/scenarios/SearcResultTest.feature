Feature: verifySearchResult

  Background: I am on main page webSite
    Given Open page "https://amazon.com/"

  Scenario Outline: Input incorrect data in search field
    When Input in search field <wrongData> end click ENTER
    And Wait page search result
    Then Search field include <wrongData>
    Then Line include text "No results for"
    Then Line include search data <wrongData>
    Examples:
      | wrongData                   |
      | "637176486948segsgsgersbvs" |

  Scenario Outline: Input search data, and check info-line result
    When Input in search field <searchData> end click ENTER
    And Wait page search result
    Then Search field include <searchData>
    Then Info-line contain text <searchData>
    Examples:
      | searchData |
      | "laptop"   |

  Scenario Outline: Input search data, and check result in card-product
    When Input in search field <searchData> end click ENTER
    And Wait page search result
    Then Search field include <searchData>
    Then At least one card product contains <searchData>
    Examples:
      | searchData |
      | "laptop"   |
      | "phone"    |
      | "keyboard" |