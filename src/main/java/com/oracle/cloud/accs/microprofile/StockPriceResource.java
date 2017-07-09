package com.oracle.cloud.accs.microprofile;

import com.oracle.cloud.accs.microprofile.common.StockPriceRetriever;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("stocks")
public class StockPriceResource {
    
    @Inject
    private StockPriceRetriever stock;

    @GET
    public Response getQuote(@QueryParam("ticker") final String ticker) {
        return Response.ok(stock.getPrice(ticker)).build();
    }

}
