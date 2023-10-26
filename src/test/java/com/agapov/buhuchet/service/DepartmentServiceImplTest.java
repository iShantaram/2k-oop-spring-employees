package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.agapov.buhuchet.service.EmployeeGenerator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getEmployeeWithMaxSalary_success() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(getAllEmployee());
        Employee expectedEmployee = getEmployee2();

        //Начало теста
        Employee actualEmployee = departmentService.getEmployeeWithMaxSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
        assertTrue(expectedEmployee.getSalary() > getEmployee1().getSalary());
    }

    @Test
    void getEmployeeWithMaxSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(Collections.emptyList());
        String expectedMessage = "No any employee";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getEmployeeWithMaxSalary(departmentId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getEmployeeWithMinSalary_success() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(getAllEmployee());
        Employee expectedEmployee = getEmployee1();

        //Начало теста
        Employee actualEmployee = departmentService.getEmployeeWithMinSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
        assertTrue(expectedEmployee.getSalary() < getEmployee2().getSalary());
    }

    @Test
    void getEmployeeWithMinSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(Collections.emptyList());
        String expectedMessage = "No any employee";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getEmployeeWithMaxSalary(departmentId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getEmployees_withDepartmentId() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(getAllEmployee());

        Collection<Employee> expectedList = Arrays.asList(getEmployee1(), getEmployee2());

        //Начало теста
        Collection<Employee> actualList = departmentService.getEmployees(departmentId);
        assertEquals(expectedList, actualList);

    }
    @Test
    void getEmployees_withoutDepartmentId() {
        //Подготовка входных данных
        Integer departmentId = null;

        //Подготовка ожидаемого результата
        when(employeeService.dataList()).thenReturn(getAllEmployee());

        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(FIRST_DEPARTMENT_ID, Arrays.asList(getEmployee1(), getEmployee2()));
        expectedMap.put(SECOND_DEPARTMENT_ID, List.of(getEmployee3()));

        //Начало теста
        Map<Integer, List<Employee>> actualMap = departmentService.getAllEmployees();
        assertEquals(expectedMap, actualMap);
    }
}