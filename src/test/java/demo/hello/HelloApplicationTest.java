package demo.hello;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import demo.hello.Controller.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        //mockMvc.perform(get("/index.html"))
        //        .andExpect(content().string(containsString("問候您")));
        MvcResult result = mockMvc.perform(get("/index.html")).andReturn();
        String content = new String(result.getResponse().getContentAsByteArray(),"UTF-8");
        assertTrue(content.contains("問候您"));        
    }

    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(content().string(containsString("您好, Docker!")));
    }

    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/hello").param("name", "微服務"))
                .andExpect(content().string(containsString("您好, 微服務!")));
    }

}
