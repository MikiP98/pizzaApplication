package pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import pl.mikolaj.pokora.pizzaapplication.domain.model.OrderStatusType;

import java.util.Date;

@Getter
@Setter
public class OrderStatusDto {

    private OrderStatusType status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedAt;
}
