package tobyspring.hellospring.exrate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedExRateProvider extends WebApiExRateProvider {
    private WebApiExRateProvider webApiExRateProvider;
    private LocalDateTime savedTime;
    private Map<String, BigDecimal> cachedRate = new ConcurrentHashMap();

    public CachedExRateProvider(WebApiExRateProvider webApiExRateProvider) {
        super(new ApiExrateTemplate());
        this.webApiExRateProvider = webApiExRateProvider;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        if(!cachedRate.containsKey(currency) || savedTime.plusSeconds(10).isBefore(LocalDateTime.now())) {
            System.out.println("http request");
            BigDecimal exrate = webApiExRateProvider.getExRate(currency);
            cachedRate.put(currency, exrate);
            savedTime = LocalDateTime.now();
            return exrate;
        }
        System.out.println("cached data");
        return cachedRate.get(currency);
    }
}
