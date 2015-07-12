package io.sytac.edu.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxfrs:bean:restInventory")
            .routeId("restInventoryRoute")
            .log(LoggingLevel.INFO, "got something!")
            .process(
                new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        exchange.getOut().setBody(
                                Response.ok().entity(
                                    "{\n" +
                                    "  \"status\": \"OK\",\n" +
                                    "  \"message\": \"stock update received\"\n" +
                                    "}").build());
                    }
                }
            );
    }
}
