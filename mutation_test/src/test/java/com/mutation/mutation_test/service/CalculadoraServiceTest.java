package com.mutation.mutation_test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    private final CalculadoraService service = new CalculadoraService();

    @Test
    void testSomar() {
        assertEquals(4, service.somar(2,2));
    }

    @Test
    void testSubtrair() {
        service.subtrair(2, 2);
    }

    @Test
    void testMultiplicar() {
        assertEquals(4,service.multiplicar(2, 2));
    }

    @Test
    void testDividir() {
        assertEquals(1,service.dividir(2, 2));
    }
    
    @Test
    void testDivisaoPorZero() {
    // Verifica se a exceção esperada é lançada
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.dividir(5, 0));
        assertEquals("Divisão por zero não é permitida.", ex.getMessage());
    }
}
