package ru.coffee.app.application.coffee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.coffee.app.domain.entity.Recipe;
import ru.coffee.app.presentation.web.controllers.coffee.dto.RecipeCommand;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecipeMapper {

    Recipe fromCommandToRecipe(RecipeCommand command);

   List<Recipe> fromCommandsToRecipies(List<RecipeCommand> command);
}
