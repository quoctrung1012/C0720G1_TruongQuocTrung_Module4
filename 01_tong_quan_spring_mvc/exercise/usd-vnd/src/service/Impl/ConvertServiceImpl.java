package service.Impl;

import org.springframework.stereotype.Service;
import service.ConvertService;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public double convert(double number) {
        return number * 23000;
    }
}
