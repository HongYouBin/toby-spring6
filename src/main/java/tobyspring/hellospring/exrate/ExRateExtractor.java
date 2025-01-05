package tobyspring.hellospring.exrate;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface ExRateExtractor {
    BigDecimal extracteExRate(String response) throws JsonProcessingException;
}
