Feature: Order Placement

  Background:
    Given User opens BurberryUK
      |browsername|Chrome|
    Given User accepts cookies


  @Order1
  Scenario Outline: User can checkout Orders
    Given User navigates to menuList
    And User select <menuName> menu
    And User select <subMenu> menu
    And User choses <sub-subMenu>
    And User click on Category
    And User get itemQuantity for the <item>
    And User selected <item> only if it is available
    And User views <productCard> link
    And User checks <size> availability
    And User picks a <size> list
    And User added it to bag
    And User checks the bag
    And User checkout the item
    And User signed in






    Examples:
      | menuName|subMenu| sub-subMenu|item|productCard|size|
      |Women    |Clothing|All Clothing|Jeans|Jeans    |30|


  @Order
  Scenario Outline: User can Notify for Orders
    Given User navigates to menuList
    And User select <menuName> menu
    And User select <subMenu> menu
    And User choses <sub-subMenu>
    And User click on Category
    And User get itemQuantity for the <item>
    And User selected <item> only if it is available
    And User views <productCard> link
    And User checks <size> availability
    And User decides to select unavailable <size> list
    And User wanted to get notified for the product





    Examples:
      | menuName|subMenu| sub-subMenu|item|productCard|size|
      |Women    |Clothing|All Clothing|Jeans|Jeans    |22|
