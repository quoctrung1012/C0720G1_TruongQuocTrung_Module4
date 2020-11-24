package service.Impl;

import org.springframework.stereotype.Service;
import service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculator(double num1, double num2, String string) {
        return getCalculator(num1,num2,string);
    }

    public Double getCalculator(double num1, double num2, String calculator) {
        double result = 0;
        switch (calculator) {
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(*)":
                result = num1 * num2;
                break;
            case "Division(/)":
                if (num2 == 0) {
                    String message = "Bạn đã nhập số 0";
                } else {
                    result = num1 / num2;
                }
                break;
        }
        return result;
    }
}
