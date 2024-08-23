package ru.coffee.app.application.coffee.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.app.application.coffee.mapper.RecipeMapper;
import ru.coffee.app.domain.entity.Coffee;


import ru.coffee.app.domain.entity.Ingredient;
import ru.coffee.app.domain.entity.Order;
import ru.coffee.app.domain.entity.Recipe;
import ru.coffee.app.infrastructure.repository.CoffeeRepository;
import ru.coffee.app.infrastructure.repository.IngredientRepository;
import ru.coffee.app.infrastructure.repository.OrderRepository;
import ru.coffee.app.infrastructure.repository.RecipeRepository;
import ru.coffee.app.presentation.web.controllers.coffee.dto.BuyCommand;
import ru.coffee.app.presentation.web.controllers.coffee.dto.BuyQuery;
import ru.coffee.app.presentation.web.controllers.coffee.dto.CoffeeCommand;


import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeService {
    private final CoffeeRepository coffeeRepository;
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final IngredientRepository ingredientRepository;
    private final OrderRepository orderRepository;


    public List<Coffee> findAll(){
        return coffeeRepository.findAll();
    }

    public Coffee findById(Integer id){
        return coffeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Кофе с таким id не найдено")
        );
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Coffee create(CoffeeCommand command){

        Coffee coffee = Coffee.builder()
                .name(command.getName())
                .price(command.getPrice())
                .build();


        List<Recipe> recipes = recipeMapper.fromCommandsToRecipies(command.getRecipe());

        recipeRepository.saveAll(recipes);

        coffee.setRecipes(recipes);

        return coffeeRepository.save(coffee);
    }

    public void delete(Integer id){
        coffeeRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BuyQuery buy(BuyCommand command){
        Coffee coffee = coffeeRepository.findById(command.getCoffeeId()).orElseThrow(
                () -> new EntityNotFoundException("кофе не найдено")
        );
        if (coffee.getPrice() > command.getMoneyAmount()){
            throw new IllegalArgumentException("недостаточно средств для покупки");
        }

        for (Recipe recipe : coffee.getRecipes()){
            String name = recipe.getName();
            Float amount = recipe.getAmount();

            Ingredient ingredient = ingredientRepository.findByName(name).orElseThrow(
                    () -> new EntityNotFoundException("ингредиент " + name + " не найден, добавьте его, прежде чем использовать в создании кофе")
            );

            if (recipe.getAmount() > ingredient.getAmount()){
                throw new RuntimeException("ингредиент " + name + " закончился, выберите другой кофе");
            }

            ingredient.setAmount(ingredient.getAmount() - amount);

            ingredientRepository.save(ingredient);

        }

        Order order = Order.builder()
                .coffeeName(coffee.getName())
                .creation(LocalDate.now())
                .build();

        orderRepository.save(order);



        return BuyQuery.builder()
                .change(command.getMoneyAmount() - coffee.getPrice())
                .coffeeName(coffee.getName())
                .build();
    }
}
