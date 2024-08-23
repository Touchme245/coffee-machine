package ru.coffee.app.application.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.coffee.app.domain.entity.Order;
import ru.coffee.app.presentation.web.controllers.order.dto.OrderQuery;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderQuery fromOrderToQuery(Order order);

    List<OrderQuery> fromOrdersToqueries(List<Order> orders);
}
