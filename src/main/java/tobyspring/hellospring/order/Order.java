package tobyspring.hellospring.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @GeneratedValue
    @Id
    private Long id;

    public Order(Long no, BigDecimal price) {
        this.no = no;
        this.price = price;
    }

    public Order() {}

    @Column(unique = true)
    private Long no;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no=" + no +
                ", price=" + price +
                '}';
    }
}
