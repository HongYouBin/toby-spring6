package tobyspring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;

import java.math.BigDecimal;

public class DataClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository orderRepository = beanFactory.getBean(OrderRepository.class);
        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);
        try {
            new TransactionTemplate(transactionManager).execute(status -> {
                Order order1 = new Order(200L, BigDecimal.valueOf(100));
                orderRepository.save(order1);

                Order order2 = new Order(200L, BigDecimal.valueOf(100));
                orderRepository.save(order2);

                return null;
            });
        } catch(DataIntegrityViolationException e) {
            System.out.println("데이터 복구 중");
        }
    }
}
