package pl.mikolaj.pokora.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mikolaj.pokora.pizzaapplication.data.entity.ordersize.OrderSizeEntity;

public interface OrderSizeRepository extends JpaRepository<OrderSizeEntity, Integer> {


    void deleteAllByOrderId(Integer orderId);
}
