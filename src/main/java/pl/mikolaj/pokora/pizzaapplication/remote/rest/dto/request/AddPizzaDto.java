package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddPizzaDto {
    private String name;
    @JsonProperty("sizes")
    private List<AddSizeDto> addSizeDtoList;


    public AddPizzaDto(){}

    public AddPizzaDto(String name, List<AddSizeDto> addSizes) {
        this.name = name;
        addSizeDtoList = addSizes;
    }

}
