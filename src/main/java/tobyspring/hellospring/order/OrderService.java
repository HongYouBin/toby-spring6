package tobyspring.hellospring.order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order createOrder(Long no, BigDecimal price);
    List<Order> createOrders(List<OrderReq> orderReqs);
}
