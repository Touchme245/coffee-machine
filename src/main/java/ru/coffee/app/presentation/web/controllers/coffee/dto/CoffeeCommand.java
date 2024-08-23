package ru.coffee.app.presentation.web.controllers.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeCommand {

    private String name;

    private Float price;

    private List<RecipeCommand> recipe;
}
