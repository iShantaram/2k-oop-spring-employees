package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.exceptions.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_COUNT_EMPLOYEES = 4;

    private final Map<String, Employee> employees = new HashMap<>(MAX_COUNT_EMPLOYEES);

    @Override
    public Employee addEmployee(String firstname, String lastname) {

        if (employees.size() >= MAX_COUNT_EMPLOYEES) {
            throw new ArrayIsFullException("State of employees is full!");
        }

        if (!StringUtils.isAlpha(firstname) || !StringUtils.isAlpha(lastname)) {
            throw new InputDataException("Input data (firstname or lastname) not correct!");
        }

        String formattedFirstname = StringUtils.capitalize(StringUtils.toRootLowerCase(firstname));
        String formattedLastname = StringUtils.capitalize(StringUtils.toRootLowerCase(lastname));

        String key = getKey(formattedFirstname, formattedLastname);

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException(key + " has already added!");
        }

        Employee newEmployee = new Employee(formattedFirstname, formattedLastname);

//        System.out.println("Added: " + newEmployee);
        return employees.put(key, newEmployee);
    }

    @Override
    public Employee removeEmployee(String firstname, String lastname) {

        if (!StringUtils.isAlpha(firstname) || !StringUtils.isAlpha(lastname)) {
            throw new InputDataException("Input data (firstname or lastname) not correct!");
        }

        String formattedFirstname = StringUtils.capitalize(StringUtils.toRootLowerCase(firstname));
        String formattedLastname = StringUtils.capitalize(StringUtils.toRootLowerCase(lastname));

        String key = getKey(formattedFirstname, formattedLastname);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Can't remove " + key + ". Employee not found!");
        }

//        System.out.println("Removed: " + employees.get(key));
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstname, String lastname) {

        if (!StringUtils.isAlpha(firstname) || !StringUtils.isAlpha(lastname)) {
            throw new InputDataException("Input data (firstname or lastname) not correct!");
        }

        String formattedFirstname = StringUtils.capitalize(StringUtils.toRootLowerCase(firstname));
        String formattedLastname = StringUtils.capitalize(StringUtils.toRootLowerCase(lastname));

        String key = getKey(formattedFirstname, formattedLastname);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(key + " not found!");
        }

//        System.out.println("Founded: " + key);
        return employees.get(key);
    }

    @Override
    public Collection<Employee> dataList() {
        return employees.values();
    }

    public String getKey(String firstname, String lastname) {
        return firstname + " " + lastname;
    }
}
