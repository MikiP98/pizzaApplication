package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import lombok.Getter;
import lombok.Setter;
import pl.mikolaj.pokora.pizzaapplication.domain.model.OrderStatusType;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.PersonOrderDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.PizzaOrderDto;

import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Integer id;
    private OrderStatusType status;
    private List<PizzaOrderDto> pizzas;
    private PersonOrderDto person;

    public OrderDto() {
    }

    public OrderDto(Integer id, OrderStatusType status, List<PizzaOrderDto> pizzas, PersonOrderDto person) {
        this.id = id;
        this.status = status;
        this.pizzas = pizzas;
        this.person = person;
    }

}