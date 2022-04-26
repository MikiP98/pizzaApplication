package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import java.util.List;

public class UpdatePizzaDto {
    private String name;
    private List<AddSizeDto> addSizeDtoList;


    public UpdatePizzaDto(){}

    public UpdatePizzaDto(String name, List<AddSizeDto> addSizes) {
        this.name = name;
        addSizeDtoList = addSizes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddSizeDto> getAddSizeDtoList() {
        return addSizeDtoList;
    }

    public void setAddSizeDtoList(List<AddSizeDto> addSizeDtoList) {
        this.addSizeDtoList = addSizeDtoList;
    }




    public List<AddSizeDto> getSizes() {
        return getAddSizeDtoList();
    }
}
