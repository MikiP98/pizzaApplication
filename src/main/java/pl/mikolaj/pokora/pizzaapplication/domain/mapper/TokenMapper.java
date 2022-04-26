package pl.mikolaj.pokora.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.mikolaj.pokora.pizzaapplication.data.entity.order.OrderEntity;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.TokenDto;

@Component
public class TokenMapper {

    public TokenDto mapToTokenDto(OrderEntity orderEntity) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(orderEntity.getToken());
        return tokenDto;
    }
}
