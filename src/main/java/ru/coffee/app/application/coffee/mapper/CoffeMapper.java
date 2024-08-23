package ru.coffee.app.application.coffee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ru.coffee.app.domain.entity.Coffee;
import ru.coffee.app.presentation.web.controllers.coffee.dto.CoffeeQuery;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeMapper {

    CoffeeQuery fromCoffeeToQuery(Coffee coffee);

    List<CoffeeQuery> fromCoffeeToQueries(List<Coffee> coffe);
}
