package com.example.app4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EndpointsApplicationTest {


    @Autowired
    private MockMvc mockMvc;



    //@Test
    public void CustomerRestControllerTest() throws Exception {
        {

            this.mockMvc.perform(get("/customer")).andDo(print()).andExpect(status().isOk());
        }
        {
            this.mockMvc.perform(get("/customer/0")).andDo(print()).andExpect(status().isOk());
        }
    }

}
