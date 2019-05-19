package app.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // Clean database after each test.
public class ExampleControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        this.mockMvc.perform(get("/example/hello_world")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("hello_world"))
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    public void testGet2() throws Exception {
        this.mockMvc.perform(get("/example/yo")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("yo"))
                .andExpect(jsonPath("$.id").value("1"));
    }

}
