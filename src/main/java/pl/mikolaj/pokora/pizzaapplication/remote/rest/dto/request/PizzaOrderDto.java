package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaOrderDto {

    private Integer id;
    private Integer sizeId;
    private Integer count;

    public PizzaOrderDto() {
    }

    public PizzaOrderDto(Integer id, Integer sizeId, Integer count) {
        this.id = id;
        this.sizeId = sizeId;
        this.count = count;
    }

}
