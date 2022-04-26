package pl.mikolaj.pokora.pizzaapplication.domain.service;

import pl.mikolaj.pokora.pizzaapplication.data.entity.order.OrderEntity;
import pl.mikolaj.pokora.pizzaapplication.data.entity.ordersize.OrderSizeEntity;
import pl.mikolaj.pokora.pizzaapplication.data.repository.OrderRepository;
import pl.mikolaj.pokora.pizzaapplication.data.repository.OrderSizeRepository;
import pl.mikolaj.pokora.pizzaapplication.data.repository.PizzaRepository;
import pl.mikolaj.pokora.pizzaapplication.data.repository.SizeRepository;
import pl.mikolaj.pokora.pizzaapplication.domain.exception.ResourceNotFoundExeption;
import pl.mikolaj.pokora.pizzaapplication.domain.mapper.TokenMapper;
import pl.mikolaj.pokora.pizzaapplication.domain.model.OrderStatusType;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.PersonOrderDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.PizzaOrderDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.TokenDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddOrderService {

    private final OrderSizeRepository orderSizeRepository;
    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final OrderRepository orderRepository;
    private final TokenMapper tokenMapper;


    public AddOrderService(OrderSizeRepository orderSizeRepository, PizzaRepository pizzaRepository, SizeRepository sizeRepository, OrderRepository orderRepository, TokenMapper tokenMapper) {
        this.orderSizeRepository = orderSizeRepository;
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
        this.orderRepository = orderRepository;
        this.tokenMapper = tokenMapper;
    }

    public TokenDto addOrder(AddOrderDto addOrderDto) {

        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(pizzaOrderDto -> pizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        Boolean existSizes = sizeRepository.existsAllByIdIn(sizeIds);
        if (!existSizes) {
            throw new ResourceNotFoundExeption("Pizza o podanym rozmiarze nie istnieje w bazie danych");
        }

        String token = UUID.randomUUID().toString();





        Date now = new Date();
        PersonOrderDto person = addOrderDto.getPersonOrderDto();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientName(person.getName());
        orderEntity.setClientAddress(person.getAddress());
        orderEntity.setClientPhone(person.getPhone());
        orderEntity.setFloor(person.getFloor());
        orderEntity.setStatus(OrderStatusType.NEW.name());
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);
        orderEntity.setToken(token);
        orderRepository.save(orderEntity);



        Integer orderId = orderEntity.getId();


        List<PizzaOrderDto> pizzaOrderDtoList = addOrderDto.getPizzas();
        List<OrderSizeEntity> orderSizeEntities = pizzaOrderDtoList
                .stream()
                .map(PizzaOrderDto -> {
                    OrderSizeEntity orderSizeEntity = new OrderSizeEntity();
                    orderSizeEntity.setSizeId(pizzaOrderDto.getSizeId());
                    orderSizeEntity.setOrderId(orderId);
                    orderSizeEntity.setSizeCount(pizzaOrderDto.getCount());
                    return orderSizeEntity;
                }).collect(Collectors.toList());
        orderSizeRepository.saveAll(orderSizeEntities);


        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        return tokenMapper.mapToTokenDto(orderEntity);
    }

}
