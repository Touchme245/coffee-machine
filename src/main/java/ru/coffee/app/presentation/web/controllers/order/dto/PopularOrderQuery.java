package ru.coffee.app.presentation.web.controllers.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PopularOrderQuery {
    private String coffeeName;

    private Integer times;
}
