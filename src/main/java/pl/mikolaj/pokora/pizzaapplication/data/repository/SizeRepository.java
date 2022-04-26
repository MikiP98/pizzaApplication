package pl.mikolaj.pokora.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.pokora.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.mikolaj.pokora.pizzaapplication.data.entity.size.SizeEntity;

import java.util.List;
import java.util.Set;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {
    void deleteAllByPizzaId(Integer pizzaId);

    boolean existsAllByIdIn(Set<Integer> ids);



    public default PizzaEntity saveAll(List<SizeEntity> sizeEntities) {

        return null;
    }
}
