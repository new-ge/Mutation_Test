package com.mutation.mutation_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutation.mutation_test.service.CalculadoraService;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/soma")
    public double somar(@RequestParam double a, @RequestParam double b) {
        return service.somar(a, b);
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestParam double a, @RequestParam double b) {
        return service.subtrair(a, b);
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return service.multiplicar(a, b);
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        return service.dividir(a, b);
    }
}

