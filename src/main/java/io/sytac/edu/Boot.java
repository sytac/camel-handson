package io.sytac.edu;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * We extend CamelConfiguration so we can build a Camel Context using purely annotated classes
 *
 */
@Configuration
@ImportResource("classpath:spring/spring.xml")
public class Boot extends CamelConfiguration {

    public static void main( String[] args ) throws Exception {

        Main main = new Main();
        //use any route builder and components declared within this package
        main.setBasedPackages("io.sytac.edu");

        main.run();

    }


}
