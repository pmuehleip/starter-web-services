package Example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ExampleController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/starter-web-services/example")
    public Example example(@RequestParam(value="name", defaultValue="World") String name) {
        return new Example(counter.incrementAndGet(), String.format(template, name));
    }
}
