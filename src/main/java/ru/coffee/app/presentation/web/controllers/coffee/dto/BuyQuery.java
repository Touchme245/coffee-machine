package ru.coffee.app.presentation.web.controllers.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyQuery {
    private String coffeeName;

    private Float change;

}
