package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstname, String lastname);
    Employee removeEmployee(String firstname, String lastname);
    Employee findEmployee(String firstname, String lastname);
    Collection<Employee> dataList();
}
