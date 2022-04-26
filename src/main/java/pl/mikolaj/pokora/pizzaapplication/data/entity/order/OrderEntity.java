package pl.mikolaj.pokora.pizzaapplication.data.entity.order;

import lombok.Getter;
import lombok.Setter;
import pl.mikolaj.pokora.pizzaapplication.data.entity.ordersize.OrderSizeEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Setter
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_address")
    private String clientAddress;

    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expected_at")
    private Date expectedAt;

    @Column(name = "token")
    private String token;

    //1 zamówienie może mieć wiele sizów
    @OneToMany(mappedBy = "order")
    private Set<OrderSizeEntity> orderSizes;



    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }
}
