package app.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping(path="/example/{content}")
    public Example example(@PathVariable String content) {
        Example example = new Example();
        example.setContent(content);
        exampleService.save(example);
        return example;
    }
}
