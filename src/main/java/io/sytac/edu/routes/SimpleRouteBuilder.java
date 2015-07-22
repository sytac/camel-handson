package io.sytac.edu.routes;

import io.sytac.edu.rest.Response;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxfrs:bean:restInventory")
            .routeId("restInventoryRoute")
                .choice()
                    .when().jsonpath("$[?(@.shoes)]")
                        .to("file:///tmp/inventory?fileName=inventory-${date:now:yyyyMMdd@HHmmssSS}.json")
                    .when().jsonpath("$[?(@.jeans)]")
                        .to("mongodb:mongoClient?database=inventory&collection=updates&operation=save")
                    .otherwise()
                        .to("file:///tmp/inventory?fileName=error-${date:now:yyyyMMdd@HHmmssSS}.json")
                .end()
            .setBody(constant(new Response("Ok", "stock update received")));
    }
}
