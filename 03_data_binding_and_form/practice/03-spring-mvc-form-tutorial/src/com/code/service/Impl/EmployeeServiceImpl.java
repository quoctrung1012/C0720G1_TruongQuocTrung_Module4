package com.code.service.Impl;

import com.code.model.Employee;
import com.code.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Map<Integer, Employee> stringEmployeeMap;

    static {
        stringEmployeeMap = new TreeMap<>();
        stringEmployeeMap.put(1, new Employee(1,"Nam1", "1A"));
        stringEmployeeMap.put(2, new Employee(2,"Nam2", "2A"));
        stringEmployeeMap.put(3, new Employee(3,"Nam3", "3A"));
        stringEmployeeMap.put(4, new Employee(4,"Nam4", "4A"));
}

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(stringEmployeeMap.values());
    }

    @Override
    public Employee getById(int id) {
        return stringEmployeeMap.get(id);
    }

    @Override
    public void save(Employee employee) {
        Integer id =(int)(Math.random()*1000);
        employee.setId(id);
        stringEmployeeMap.put(id, employee);
    }
}
