package com.dataPersistence.Data.Store.Persistence.DeliveryPlants;

import org.hibernate.annotations.Nationalized;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;
    @Column(precision = 12, scale=4)
    private BigDecimal price; // BigDecimal is the standard Java class for currency math

    @ManyToOne  //many plants can belong to one delivery
    @JoinColumn(name="delivery_id") //map the join column in the plant table
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
