Feature: Searching some devices by established criteria

  Scenario Outline: choose TV sets by established criteria
    Given browser is launched
    And Onliner web-site start page is opened
    When user navigates to the menu section "Каталог"
    And user navigates to the catalogue section "Электроника"
    And user chooses catalogue sub section "Телевидение и видео"
    And user chooses sub section entity "Телевизоры"
    And user chooses "<producer>" in the checkbox list "Производитель"
    And user chooses "<resolution>" in the checkbox list "Разрешение"
    And user sets "<minPrice>" and "<maxPrice>" in the range inputs "Минимальная цена в предложениях магазинов"
    And user sets "<minSize>" and "<maxSize>" in the dropdown "Диагональ"
    Then the producer of the product should be "<producer>"
    And the resolution of the product should be "<resolution>"
    And the price of the product should be between "<minPrice>" and "<maxPrice>"
    And the size of the product should be between "<minSize>" and "<maxSize>"
    And user closes browser

    Examples:
      | producer |  | resolution          |  | minPrice |  | maxPrice |  | minSize |  | maxSize |  |
      | Samsung  |  | 1920x1080 (Full HD) |  | 0        |  | 1500.00  |  | 40      |  | 50      |  |
