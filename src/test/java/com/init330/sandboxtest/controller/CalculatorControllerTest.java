package com.init330.sandboxtest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void plus_return() throws Exception {
        mockMvc.perform(get("/api/plus").param("a","2").param("b","3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void minus_return() throws Exception{
        mockMvc.perform(get("/api/minus").param("a","10").param("b","3"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void multi_return() throws Exception{
        mockMvc.perform(get("/api/multiply").param("a","2").param("b","3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    void divide_return() throws Exception{
        mockMvc.perform(get("/api/divide").param("a","10").param("b","2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void divide_exception() throws Exception{
        mockMvc.perform(get("/api/divide").param("a","10").param("b","0"))
                .andExpect(status().isBadRequest());
    }
}
