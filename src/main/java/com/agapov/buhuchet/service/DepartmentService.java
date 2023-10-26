package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Collection<Employee> getEmployees(Integer departmentId);
    Map<Integer, List<Employee>> getAllEmployees();
}
