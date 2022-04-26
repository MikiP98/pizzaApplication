package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class AddOrderDto {

    private Integer id;

    public Arrays getPizzas() {
        return null;
    }

    public PersonOrderDto getPersonOrderDto() {
        return null;
    }
}
