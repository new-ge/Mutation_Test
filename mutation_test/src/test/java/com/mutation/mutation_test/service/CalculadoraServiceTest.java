package com.mutation.mutation_test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    private final CalculadoraService service = new CalculadoraService();

    @Test
    void testSomar() {
        assertEquals(5.0, service.somar(3,2));
    }

    @Test
    void testSubtrair() {
        assertEquals(1,service.subtrair(3, 2));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6,service.multiplicar(3, 2));
    }

    @Test
    void testDividir() {
        assertEquals(1.5,service.dividir(3, 2));
    }
    
    @Test
    void testDivisaoPorZero() {
    // Verifica se a exceção esperada é lançada
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.dividir(5, 0));
        assertEquals("Divisão por zero não é permitida.", ex.getMessage());
    }
}
