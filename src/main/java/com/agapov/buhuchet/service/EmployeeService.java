package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstname, String lastname);
    Employee add(String firstname, String lastname, Integer departmentId, Double salary);
    Employee add(Employee employee);
    Employee remove(String firstname, String lastname);
    Employee find(String firstname, String lastname);
    Collection<Employee> dataList();
}
