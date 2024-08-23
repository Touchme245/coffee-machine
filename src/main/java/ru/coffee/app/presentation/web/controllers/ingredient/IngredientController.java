package ru.coffee.app.presentation.web.controllers.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.app.application.ingredient.mapper.IngredientMapper;
import ru.coffee.app.application.ingredient.service.IngredientService;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.FillIngredientCommand;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.IngredientCommand;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.IngredientQuery;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;
    @GetMapping
    public List<IngredientQuery> findAll(){
        return ingredientMapper.fromIngredientsToQueries(
                ingredientService.findAll()
        );
    }
    @PostMapping
    public IngredientQuery create(@RequestBody IngredientCommand command){
        return ingredientMapper.fromIngredientToQuery(
                ingredientService.create(command)
        );
    }
    @PostMapping("/fill")
    public IngredientQuery fill(@RequestBody FillIngredientCommand command){
        return ingredientMapper.fromIngredientToQuery(
                ingredientService.fill(command)
        );
    }
}
