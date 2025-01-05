package tobyspring.hellospring.exrate;

import java.math.BigDecimal;

public class WebApiExRateProvider implements ExRateProvider {
    ApiExrateTemplate apiExrateTemplate;

    public WebApiExRateProvider(ApiExrateTemplate apiExrateTemplate) {
        this.apiExrateTemplate = apiExrateTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        String uri = "https://open.er-api.com/v6/latest/" + currency;
        return apiExrateTemplate.getExRate(uri);
    }
}
