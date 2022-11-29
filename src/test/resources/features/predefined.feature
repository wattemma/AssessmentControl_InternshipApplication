#Automate search for different search engines
#https://jira.portnov.com/browse/ACD-554
  #  Author: Emma Watt
@predefined
Feature: Smoke steps


  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Gibiru
    Given I open url "http://gibiru.com"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//*[@id='web-results']/div/div" to be present
    Then element with xpath "//*[@id='web-results']/div/div" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Duckduckgo
    Given I open url "https://duckduckgo.com"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element using JavaScript with xpath "//*[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title as "Your private und anonymous search engine Swisscows"
    Then element with xpath "//input[@type='search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@type='search']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input" should be present
    When I type "Behavior Driven Development" into element with xpath "//input"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title as "Startpage - Private Search Engine. No Tracking. No Search History."
    Then element with xpath "//*[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@id='q']"
    Then I click on element using JavaScript with xpath "//*[@id='search-btn']"
    Then I wait for element with xpath "//*[contains(text(),'Web results')]/.." to be present
    Then element with xpath "//*[contains(text(),'Web results')]/.." should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then element with xpath "//div[@class='content__left']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@type='search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@type='search']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//*[@data-test-id='mainline']" to be present
    Then element with xpath "//*[@data-test-id='mainline']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Wiki
    #iframe
    Given I open url "https://www.wiki.com/"
    Then I should see page title as "Wiki.com"
    Then element with xpath "//input [@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input [@name='q']"
    Then I click on element using JavaScript with xpath "//*[@value='Wiki Search']"
    Then I click on element using JavaScript with xpath "//button[@id='proceed-button']"
    Then I switch to the iframe, and see "Cucumber" in the results, and switch back


  @predefined10
  Scenario: Predefined steps for Givewater
    Given I open url "https://www.givewater.com/"
    Then I should see page title as "Search the Web to Give Clean Water to Those in Need » giveWater Search Engine"
    Then element with xpath "//input[@id='site-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='site-search']"
    Then I click on element using JavaScript with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='layout']" to be present
    Then element with xpath "//div[@class='layout']" should contain text "Cucumber"

  @predefined11
    #doesn't work, how to pause the browser
  Scenario: Predefined steps for Ekoru
    Given I open url "https://ekoru.org/"
    Then I should see page title as "Ekoru - every search cleans our oceans"
    Then element with xpath "//input[@id='fld_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='fld_q']"
    Then I click on element using JavaScript with xpath "//*[@id='btn_search']"
    Then I wait for element with xpath "//div[@class='serp-wrapper']" to be present
    Then element with xpath "//*[@id='div_results']" should contain text "Cucumber"


