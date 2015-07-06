package nl.sytac.edu.components.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxfrs:bean:restInventory")
                .log(LoggingLevel.INFO, "got something!");
    }
}
