package nl.sytac.edu;

import nl.sytac.edu.components.routes.SimpleRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Bean;

/**
 * We extend CamelConfiguration so we can build a Camel Context using purely annotated classes
 *
 */
public class Boot extends CamelConfiguration {

    public static void main( String[] args ) throws Exception {

        Main main = new Main();
        //use any route builder and components declared within this package
        main.setBasedPackages("nl.sytac.edu.components");

        main.run();
        System.out.println("ciao");
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        return new SpringCamelContext(getApplicationContext());
    }

    @Bean
    public RouteBuilder getSimpleRouteBuilder() {
        return new SimpleRouteBuilder();
    }
}
