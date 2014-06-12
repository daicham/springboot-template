package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SampleApplication {

    public static void main(String... args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
