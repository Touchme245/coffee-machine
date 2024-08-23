package ru.coffee.app.presentation.web.controllers.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.app.application.order.mapper.OrderMapper;
import ru.coffee.app.application.order.service.OrderService;
import ru.coffee.app.presentation.web.controllers.order.dto.OrderQuery;
import ru.coffee.app.presentation.web.controllers.order.dto.PopularOrderQuery;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderQuery> findAll(){
        return orderMapper.fromOrdersToqueries(
                orderService.findAll()
        );
    }
    @GetMapping("/popular")
    public PopularOrderQuery findPopularest(){
        return orderService.findPopularest();
    }

}
