package io.sytac.edu;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * We extend CamelConfiguration so we can build a Camel Context using purely annotated classes
 *
 */
@Configuration
@ImportResource({"classpath:spring/spring.xml", "classpath:META-INF/cxf/cxf.xml"})
public class Boot extends CamelConfiguration {


    public static void main( String[] args ) throws Exception {

        Main main = new Main();
        //use any route builder and components declared within this package
        main.setBasedPackages("io.sytac.edu");

        main.run();

    }


    /**
     * Bean implicitly used by cxf to serialize to json
     * @param objectMapper
     * @return
     */
    @Bean(name = "jacksonJsonProvider")
    public JacksonJsonProvider jsonProvider(ObjectMapper objectMapper) {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(objectMapper);
        return provider;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
