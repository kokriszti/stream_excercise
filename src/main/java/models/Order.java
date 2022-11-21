package models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "product_order")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String status;

    @Column(name = "order_date")
    LocalDate oderDate;

    @Column(name = "delivery_date")
    LocalDate deliveryDate;

    @ManyToMany
    @JoinTable(
            name = "order_product_relationship",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
            @ToString.Exclude
            @EqualsAndHashCode.Exclude
    List<Product> products;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
