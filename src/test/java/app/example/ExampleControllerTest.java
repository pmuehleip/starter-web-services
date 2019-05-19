package app.example;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"test"})
public class ExampleControllerTest {

    @Autowired
    private ExampleController controller;

    @Autowired
    private ExampleService exampleService;

    @BeforeEach
    public void cleanup() {
        exampleService.deleteAll();
    }

    @Test
    public void testGet() {
        Example ex = controller.example("people");

        assertEquals(1, Lists.newArrayList(exampleService.findAll()).size());
        assertEquals("people", ex.getContent());
    }

    @Test
    public void testGet2() {
        Example ex = controller.example("yo");
        assertEquals(1, Lists.newArrayList(exampleService.findAll()).size());
        assertEquals("yo", ex.getContent());
    }
}
