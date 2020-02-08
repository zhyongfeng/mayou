package com.mayou.community;

import com.mayou.community.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
    }

    @WebMvcTest(controllers = HelloController.class)
    public static class ServingnWebContentApplicationTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void homePage() throws Exception {
            // N.B. jsoup can be useful for asserting HTML content
            mockMvc.perform(get("/index.html"))
                    .andExpect(content().string(containsString("Get your greeting")));
        }

        @Test
        public void greeting() throws Exception {
            mockMvc.perform(get("/greeting"))
                    .andExpect(content().string(containsString("Hello, World!")));
        }

        @Test
        public void greetingWithUser() throws Exception {
            mockMvc.perform(get("/greeting").param("name", "Greg"))
                    .andExpect(content().string(containsString("Hello, Greg!")));
        }

    }
}
