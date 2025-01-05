package tobyspring.hellospring.order;

import java.math.BigDecimal;

public record OrderReq(Long no, BigDecimal price) {
}
