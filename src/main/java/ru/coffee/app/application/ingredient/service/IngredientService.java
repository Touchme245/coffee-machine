package ru.coffee.app.application.ingredient.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.app.domain.entity.Ingredient;
import ru.coffee.app.infrastructure.repository.IngredientRepository;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.FillIngredientCommand;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.IngredientCommand;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;


    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public  Ingredient findById(Integer id){
        return ingredientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ингридиент не найден")
        );
    }

    public Ingredient create(IngredientCommand command){
        Ingredient ingredient = Ingredient.builder()
                .amount(command.getAmount())
                .name(command.getName())
                .build();

        return ingredientRepository.save(ingredient);
    }

    public Ingredient fill(FillIngredientCommand command){
        Ingredient ingredient = ingredientRepository.findById(command.getId()).orElseThrow(
                () -> new EntityNotFoundException("ингридиет не найден")
        );
        ingredient.setAmount(ingredient.getAmount() + command.getAmount());

        return ingredientRepository.save(ingredient);
    }
}
