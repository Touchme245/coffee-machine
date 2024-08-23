package ru.coffee.app.application.ingredient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.coffee.app.domain.entity.Ingredient;
import ru.coffee.app.presentation.web.controllers.ingredient.dto.IngredientQuery;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {

    IngredientQuery fromIngredientToQuery(Ingredient ingredient);

    List<IngredientQuery> fromIngredientsToQueries(List<Ingredient> ingredients);
}
