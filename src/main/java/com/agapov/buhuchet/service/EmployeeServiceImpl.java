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
    private final int MAX_COUNT_EMPLOYEES = 3;

    private final Map<String, Employee> employees = new HashMap<>(MAX_COUNT_EMPLOYEES);

    @Override
    public Employee add(String firstname, String lastname) {

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

        return employees.put(key, newEmployee);
    }

    @Override
    public Employee remove(String firstname, String lastname) {

        if (!StringUtils.isAlpha(firstname) || !StringUtils.isAlpha(lastname)) {
            throw new InputDataException("Input data (firstname or lastname) not correct!");
        }

        String formattedFirstname = StringUtils.capitalize(StringUtils.toRootLowerCase(firstname));
        String formattedLastname = StringUtils.capitalize(StringUtils.toRootLowerCase(lastname));

        String key = getKey(formattedFirstname, formattedLastname);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Can't remove " + key + ". Employee not found!");
        }

        return employees.remove(key);
    }

    @Override
    public Employee find(String firstname, String lastname) {

        if (!StringUtils.isAlpha(firstname) || !StringUtils.isAlpha(lastname)) {
            throw new InputDataException("Input data (firstname or lastname) not correct!");
        }

        String formattedFirstname = StringUtils.capitalize(StringUtils.toRootLowerCase(firstname));
        String formattedLastname = StringUtils.capitalize(StringUtils.toRootLowerCase(lastname));

        String key = getKey(formattedFirstname, formattedLastname);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException(key + " not found!");
        }

        return employees.get(key);
    }

    @Override
    public Collection<Employee> dataList() {
        return employees.values();
    }

    @Override
    public Employee add(String firstname, String lastname, Integer departmentId, Double salary) {

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

        Employee newEmployee = new Employee(formattedFirstname, formattedLastname, departmentId, salary);

//        return employees.put(key, newEmployee);
//  тест показывает, что возвращается null, если использовать закомментированную строку вместо двух нижних
        employees.put(key, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        return add(employee.getFirstname(), employee.getLastname(), employee.getDepartment(), employee.getSalary());
    }

    public String getKey(String firstname, String lastname) {
        return firstname + " " + lastname;
    }
}
