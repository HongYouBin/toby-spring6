package tobyspring.hellospring.exrate;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiExrateTemplate {
    private final ApiExecutor apiExecutor;
    private final ExRateExtractor exRateExtractor;

    public ApiExrateTemplate() {
        this.apiExecutor = new SimpleApiExcutor();
        this.exRateExtractor = new SimpleExRateExtractor();
    }

    public BigDecimal getExRate(String url) {
        return getExRate(url, this.apiExecutor, this.exRateExtractor);
    }

    public BigDecimal getExRate(String url, ApiExecutor apiExecutor, ExRateExtractor exRateExtractor) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String response;
        try {
            response = apiExecutor.execute(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return exRateExtractor.extracteExRate(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
