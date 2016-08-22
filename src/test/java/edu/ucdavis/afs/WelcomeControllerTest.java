package edu.ucdavis.afs;

import edu.ucdavis.afs.controller.WelcomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new WelcomeController()).build();
    }

    @Test
    public void testWelcome() throws Exception {
        this.mockMvc.perform(get("/welcome.htm"))
                .andExpect(status().isOk())
                .andExpect(content().string("UCD Java Developer Coding Test"));
    }
}
