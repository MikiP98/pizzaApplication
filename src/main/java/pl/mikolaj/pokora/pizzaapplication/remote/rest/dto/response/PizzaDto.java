package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PizzaDto {

    private Integer id;
    private String name;
    private List<SizeDto> sizes;

    public PizzaDto() {

    }

    public PizzaDto(Integer id, String name, List<SizeDto> sizes) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
    }

}