package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableAutoConfiguration
public class SampleController {

    // Return just string
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    // Return Object as JSON (using jackson-databind)
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format("Hello, %s", name));
    }

    public static void main(String... args) {
        SpringApplication.run(SampleController.class, args);
    }
}
