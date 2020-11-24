package service.Impl;

import org.springframework.stereotype.Service;
import service.CalculatorService;
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculatorSum(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double calculatorSub(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double calculatorMulti(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double calculatorDiv(double num1, double num2) {
        return num1 / num2;
    }
}
