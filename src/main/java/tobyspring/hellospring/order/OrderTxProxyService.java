package tobyspring.hellospring.order;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;

public class OrderTxProxyService implements OrderService {
    private final PlatformTransactionManager platformTransactionManager;
    private final OrderService orderService;

    public OrderTxProxyService(PlatformTransactionManager platformTransactionManager, OrderService orderService) {
        this.platformTransactionManager = platformTransactionManager;
        this.orderService = orderService;
    }

    @Override
    public Order createOrder(Long no, BigDecimal price) {
        return new TransactionTemplate(platformTransactionManager).execute(
                status -> orderService.createOrder(no, price)
        );
    }

    @Override
    public List<Order> createOrders(List<OrderReq> orderReqs) {
        return new TransactionTemplate(platformTransactionManager).execute(
                status -> orderService.createOrders(orderReqs)
        );
    }
}
