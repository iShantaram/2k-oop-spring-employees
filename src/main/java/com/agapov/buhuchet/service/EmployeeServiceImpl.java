package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.exceptions.EmployeeAlreadyAddedException;
import com.agapov.buhuchet.exceptions.EmployeeNotFoundException;
import com.agapov.buhuchet.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_COUNT_EMPLOYEES = 5;
    List<Employee> employees = new ArrayList<>(MAX_COUNT_EMPLOYEES);

    @Override
    public Employee addEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee " + employee + " has already added!");
        }
        if (employees.size() == MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("State of employees is full!");
        }
        employees.add(employee);
        System.out.println("В коллекцию сотрудников добавлен: " + employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Can't remove employee " + employee + ". Employee not found!");
        } else {
            employees.remove(employee);
        }
        System.out.println("Из коллекции сотрудников удален: " + employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (employees.contains(employee)) {
            System.out.println("В коллекции сотрудников найден: " + employee);
            return employees.get(employees.indexOf(employee));
        }
        throw new EmployeeNotFoundException("Employee " + employee + " not found!");
    }

    @Override
    public List<Employee> dataList() {
        return employees;
    }
}
