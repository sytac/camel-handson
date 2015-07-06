package nl.sytac.edu;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.context.annotation.Configuration;

/**
 * We extend CamelConfiguration so we can build a Camel Context using purely annotated classes
 *
 */
@Configuration
public class Boot extends CamelConfiguration {

    public static void main( String[] args ) throws Exception {

        Main main = new Main();
        //use any route builder and components declared within this package
        main.setFileApplicationContextUri("classpath:/spring/spring.xml");
        main.setBasedPackages("nl.sytac.edu");

        main.run();

    }


}
