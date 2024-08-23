package ru.coffee.app.presentation.web.controllers.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyCommand {
    private Float moneyAmount;

    private Integer coffeeId;
}
