package tobyspring.hellospring.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Long no, BigDecimal price) {
        Order order = new Order(no, price);
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> createOrders(List<OrderReq> orderReqs) {
        return orderReqs.stream()
                .map(req -> createOrder(req.no(), req.price()))
                .toList();
    }
}
