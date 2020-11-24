package com.codegym.service.Impl;

import com.codegym.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImplSum implements CalculatorService {
    @Override
    public double calculator(double num1, double num2) {
        return num1 + num2;
    }
}
