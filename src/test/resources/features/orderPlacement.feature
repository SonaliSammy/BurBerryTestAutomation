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






    Examples:
      | menuName|subMenu| sub-subMenu|item|productCard|size|
      |Women    |Clothing|All Clothing|Jeans|Jeans      |30|
