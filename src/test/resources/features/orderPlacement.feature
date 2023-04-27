Feature: Order Placement

  Background:
    Given User opens BurberryUK
      |browsername|Chrome|
    Given User accepts cookies


  @Order
  Scenario Outline: User can checkout Orders
    Given User navigates to menuList
    And User select <menuName> menu
    And User select <subMenu> menu
    And User choses <subMenu>
    And User click on Category
    And User select <subMenu> menu
    And User select <sub-subMenu> menu
    And User select <categoryType> menu
    And User get itemQuantity
    And User select <item> menu
    And User select <productCard> menu
    And User checks Size availability
    And User select <size> menu
    And User added it to bag
    And User naviagates to bag






    Examples:
      | menuName|subMenu| sub-subMenu|categoryType|item|productCard|size|
      |Women    |Clothing|All Clothing|Category|Jeans  |Jeans      |30|
