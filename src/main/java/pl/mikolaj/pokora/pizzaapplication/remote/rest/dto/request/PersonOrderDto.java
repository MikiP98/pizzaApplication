package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonOrderDto {
    private String name;
    private String phone;
    private String address;
    private Integer floor;

    public PersonOrderDto() {
    }

    public PersonOrderDto(String name, String phone, String address, Integer floor) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Integer getFloor() {
        return floor;
    }
}
