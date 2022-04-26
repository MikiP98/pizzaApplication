package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddSizeDto {

    private String name;
    @JsonProperty("sizes")
    private List<AddPizzaDto> addPizzaDtoList;

    public AddSizeDto() {
    }

    public AddSizeDto(String name, List<AddPizzaDto> addPizzaDtoList) {
        this.name = name;
        this.addPizzaDtoList = addPizzaDtoList;
    }




    public <E extends Enum<E>> Enum<E> getSize() {
        return null;
    }

    public Object getPrice() {
        return null;
    }
}
