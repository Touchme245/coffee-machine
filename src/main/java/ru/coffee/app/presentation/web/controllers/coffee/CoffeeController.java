package ru.coffee.app.presentation.web.controllers.coffee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.app.application.coffee.mapper.CoffeMapper;
import ru.coffee.app.application.coffee.service.CoffeService;
import ru.coffee.app.presentation.web.controllers.coffee.dto.BuyCommand;
import ru.coffee.app.presentation.web.controllers.coffee.dto.BuyQuery;
import ru.coffee.app.presentation.web.controllers.coffee.dto.CoffeeCommand;
import ru.coffee.app.presentation.web.controllers.coffee.dto.CoffeeQuery;
import java.util.List;

@RestController
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeService coffeService;
    private final CoffeMapper coffeMapper;

    @GetMapping()
    public List<CoffeeQuery> findAll(){
        return coffeMapper.fromCoffeeToQueries(
                coffeService.findAll()
        );
    }
    @GetMapping("/{id}")
    public CoffeeQuery findById(@PathVariable(name = "id") Integer id){
        return coffeMapper.fromCoffeeToQuery(
                coffeService.findById(id)
        );
    }
    @PostMapping
    public CoffeeQuery create(@RequestBody CoffeeCommand command){

        return coffeMapper.fromCoffeeToQuery(
              coffeService.create(command)
        );
    }
    @DeleteMapping
    public void delete(@PathVariable(name = "id") Integer id){
        coffeService.delete(id);
    }
    @PostMapping("/buy")
    public BuyQuery buyCoffe(@RequestBody BuyCommand command){
        return coffeService.buy(command);
    }
}
