package com.init330.sandboxtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/plus")
    public int plus(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a + b;
    }

    @GetMapping("/minus")
    public int minus(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a - b;
    }

    @GetMapping("/multiply")
    public int multiply(
            @RequestParam int a,
            @RequestParam int b
    ){
        return a * b;
    }

    @GetMapping("/divide")
    public int divide(
            @RequestParam int a,
            @RequestParam int b
    ){
        if(b == 0){
            throw new IllegalArgumentException("b must not be 0");
        }
        return a / b;
    }
}
