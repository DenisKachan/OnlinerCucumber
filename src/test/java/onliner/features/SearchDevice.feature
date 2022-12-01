Feature: Searching some devices by established criteria

  Scenario Outline: choose TV sets by established criteria
    Given Onliner web-site start page is opened
    When user navigates to the menu section "Каталог"
    And user navigates from catalogue section "Электроника" to the catalogue sub section "Телевидение и видео" and chooses "Телевизоры"
    And user sets "<producer>" as "Производитель", "<resolution>" as "Разрешение", "<minPrice>" and "<maxPrice>" in the inputs of "Минимальная цена в предложениях магазинов", "<minSize>" and "<maxSize>" as "Диагональ"
    Then the product should meet established criteria of "<producer>", "<resolution>", "<minPrice>", "<maxPrice>", "<minSize>" and "<maxSize>"

    Examples:
      | producer |  | resolution          |  | minPrice |  | maxPrice |  | minSize |  | maxSize |  |
      | Samsung  |  | 1920x1080 (Full HD) |  | 0        |  | 1500.00  |  | 40\"    |  | 50\"    |  |
