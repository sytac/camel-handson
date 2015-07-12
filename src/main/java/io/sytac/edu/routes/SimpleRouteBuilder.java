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
            .to("mongodb:mongoClient?database=inventory&collection=updates&operation=save")
            .setBody(constant(new Response("Ok", "stock update received")));
    }
}
