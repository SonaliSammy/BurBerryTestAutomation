Feature: Order Placement

  Background:
    Given User opens BurberryUK
      |browsername|Chrome|
    Given User accepts cookies


  @Order
  Scenario Outline: User can checkout Orders
    Given User select <menuName> menu

    Examples:
      | menuName|
      |Women    |
