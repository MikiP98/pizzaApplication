package pl.mikolaj.pokora.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.pokora.pizzaapplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {


    void deleteById(Integer pizzaId);
}
