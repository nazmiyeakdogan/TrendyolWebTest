Feature: Trendyol Web Test

  Background:
    Given Navigate to Trendyol
    When Enter user information
    And Click login
    Then Verify successful login

  Scenario: User select product and complete shopping
    When Search for product
    And Apply filter for product
    And Click on the product and add to cart
    And Delete product from cart and add to favorites
    And Add product back to cart and pay
