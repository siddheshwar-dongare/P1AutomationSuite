@AddToCart
@LoginRequired
Feature: Add to cart
    Scenario: Add product to cart
        Given user is on product details page
        When user click on add to cart button
        Then product is added oin the cart successfully