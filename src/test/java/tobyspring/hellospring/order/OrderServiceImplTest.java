package tobyspring.hellospring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.OrderConfig;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderConfig.class)
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrder() {
        Order order = orderService.createOrder(200L, BigDecimal.valueOf(100));

        assertThat(order.getId()).isGreaterThan(0);
    }

    @Test
    void createOrders() {
        List<OrderReq> orderReqs = List.of(
                new OrderReq(200L, BigDecimal.valueOf(100)),
                new OrderReq(200L, BigDecimal.valueOf(120))
        );

        assertThatThrownBy(()->orderService.createOrders(orderReqs)).isInstanceOf(DataIntegrityViolationException.class);


    }
}