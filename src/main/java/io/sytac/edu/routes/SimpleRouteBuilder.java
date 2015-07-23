package io.sytac.edu.routes;

import io.sytac.edu.rest.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    public static final String FILE_INVENTORY_ENDPOINT = "file:///tmp/inventory?fileName=inventory-${date:now:yyyyMMdd@HHmmssSS}.json";
    public static final String MONGO_INVENTORY_ENDPOINT = "mongodb:mongoClient?database=inventory&collection=updates&operation=save";
    public static final String FILE_ERROR_ENDPOINT = "file:///tmp/inventory?fileName=error-${date:now:yyyyMMdd@HHmmssSS}.json";

    @Override
    public void configure() throws Exception {
        from("cxfrs:bean:restInventory")
            .routeId("restInventoryRoute")
                .choice()
                    .when().jsonpath("$[?(@.shoes)]")
                        .to(FILE_INVENTORY_ENDPOINT)
                    .when().jsonpath("$[?(@.jeans)]")
                        .to(MONGO_INVENTORY_ENDPOINT)
                    .otherwise()
                        .to(FILE_ERROR_ENDPOINT)
                .end()
            .setBody(constant(new Response("Ok", "stock update received")));
    }
}
