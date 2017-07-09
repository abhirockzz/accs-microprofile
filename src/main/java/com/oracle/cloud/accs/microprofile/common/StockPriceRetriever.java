package com.oracle.cloud.accs.microprofile.common;

import com.oracle.cloud.accs.microprofile.exceptions.InvalidTickerException;
import com.oracle.cloud.accs.microprofile.exceptions.PriceFetchException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@Dependent
public class StockPriceRetriever {

    @Inject
    private StockDataParser parser;

    public String getPrice(String ticker) {
        String tick = null;

        if (ticker == null) {
            throw new InvalidTickerException();
        }

        Future<Response> promise = ClientBuilder.newClient().
                target("https://www.google.com/finance/info?q=NASDAQ:" + ticker).
                request().async().get();

        Response response;
        try {
            response = promise.get(5, TimeUnit.SECONDS);
        } catch (Exception ex) {
            throw new PriceFetchException(ticker);
        } 
        
        tick = response.readEntity(String.class);
        tick = tick.replace("// [", "");
        tick = tick.replace("]", "");

        return parser.parse(tick);
    }
}
