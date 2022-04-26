package pl.mikolaj.pokora.pizzaapplication.domain.mapper;

import pl.mikolaj.pokora.pizzaapplication.data.entity.size.SizeEntity;
import pl.mikolaj.pokora.pizzaapplication.domain.model.SizeType;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.mikolaj.pokora.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

public class SizeMapper {

    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId) {
        SizeEntity sizeEntity = new SizeEntity();
        SizeEntity.setSizeType(addSizeDto.getSize().name());
        SizeEntity.setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }

    public SizeDto mapToSizeDto(SizeEntity sizeEntity) {
        SizeDto sizeDto = new SizeDto();
        sizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        sizeDto.setPrice(sizeEntity.getPriceBase());
        sizeDto.setId(sizeEntity.getId());
        return sizeDto;
    }
}
