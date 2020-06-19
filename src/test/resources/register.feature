Feature:Login to NopCommerce
  Register

  Scenario:Register new user and login
    Given User is at homepage
    When  I click on register link from nav bar
    Then  I should be navigated to register page
    When  I enter mandatory fields
    And   I click register button
    When I am on home showing registration successful message
