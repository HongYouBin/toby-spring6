package tobyspring.hellospring.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private Long orderId; // 주문 번호
    private String currency; // 외국 통화 종류
    //정확한 소수점 구현 위해 BigDecimal 사용해야 한다.
    private BigDecimal foreignCurrencyAmount; // 해외 통화 결제 금액
    private BigDecimal exRate; // 적용 환율
    private BigDecimal convertedAmount; // 원화 환산 금액
    private LocalDateTime validUntil; // 원화 환산 금액 유효시간

    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exRate, BigDecimal convertedAmount, LocalDateTime validUntil) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUntil = validUntil;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUntil=" + validUntil +
                '}';
    }
}
