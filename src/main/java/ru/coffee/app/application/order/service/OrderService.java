package ru.coffee.app.application.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.app.domain.entity.Order;
import ru.coffee.app.infrastructure.repository.OrderRepository;
import ru.coffee.app.presentation.web.controllers.order.dto.PopularOrderQuery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public PopularOrderQuery findPopularest(){
        List<Object[]> Object = orderRepository.findMostPopularCoffee();

        return PopularOrderQuery.builder()
                .coffeeName(Object.get(0)[0].toString())
                .times(Integer.valueOf(Object.get(0)[1].toString()))
                .build();

    }
}
