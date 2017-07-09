package com.oracle.cloud.accs.microprofile.common;

import com.oracle.cloud.accs.microprofile.exceptions.ParsingException;
import java.io.StringReader;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * A simple utility class which leverages the JSON Processing (JSON-P) API to
 * filter the JSON payload obtained from the Google Finance REST endpoint and
 * returns useful data in a custom format
 *
 */
@ApplicationScoped
public class StockDataParser {

    public String parse(String data) {
        String result = null;
        try {
            JsonReader reader = Json.createReader(new StringReader(data));
            JsonObject priceJsonObj = reader.readObject();
            String name = priceJsonObj.getJsonString("t").getString();
            String price = priceJsonObj.getJsonString("l_cur").getString();
            String time = priceJsonObj.getJsonString("lt_dts").getString();

            result = String.format("Price for %s on %s = %s USD", name, time, price);
        } catch (Exception e) {
            throw new ParsingException();
        }

        return result;
    }
}
