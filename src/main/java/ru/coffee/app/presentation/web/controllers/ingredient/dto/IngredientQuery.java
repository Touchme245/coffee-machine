package ru.coffee.app.presentation.web.controllers.ingredient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientQuery {
    private Integer id;

    private String name;

    private Float amount;
}
