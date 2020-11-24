package service;


import org.springframework.stereotype.Service;
import service.impl.SimpleCustomerServiceImpl;
@Service
public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
