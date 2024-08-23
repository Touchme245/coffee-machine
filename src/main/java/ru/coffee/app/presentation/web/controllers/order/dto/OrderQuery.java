package ru.coffee.app.presentation.web.controllers.order.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.coffee.app.domain.entity.Coffee;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderQuery {
    private Integer id;

    private String coffeeName;

    private LocalDate creation;
}
