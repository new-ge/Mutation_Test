package com.mutation.mutation_test.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.mutation.mutation_test.service.CalculadoraService;

@WebMvcTest(CalculadoraController.class)
@Import(CalculadoraController.class)
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculadoraService service;

    @Test
    void testSomar() throws Exception {
        when(service.somar(2, 3)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculadora/soma?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testSubtrair() throws Exception {
        when(service.subtrair(5, 3)).thenReturn(2.0);

        mockMvc.perform(get("/api/calculadora/subtrair?a=5&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testMultiplicar() throws Exception {
        when(service.multiplicar(4, 5)).thenReturn(20.0);

        mockMvc.perform(get("/api/calculadora/multiplicar?a=4&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("20.0"));
    }

    @Test
    void testDividir() throws Exception {
        when(service.dividir(10, 2)).thenReturn(5.0);

        mockMvc.perform(get("/api/calculadora/dividir?a=10&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testDividirPorZero() throws Exception {
        when(service.dividir(5, 0)).thenThrow(new IllegalArgumentException("Divisão por zero não é permitida."));

        mockMvc.perform(get("/api/calculadora/dividir?a=5&b=0"))
                .andExpect(status().isInternalServerError()); 
    }
}
