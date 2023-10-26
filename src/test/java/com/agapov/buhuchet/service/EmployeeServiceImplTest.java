package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.exceptions.*;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    void add_success() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstname, lastname, departmentId, salary);

        //Начало теста
        Employee actualEmployee = employeeService.add(firstname, lastname, departmentId, salary);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_withArrayIsFullException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        String firstname2 = "Ivan";
        String lastname2 = "IvanovSecond";
        double salary2 = 85000;

        String firstname3 = "Ivan";
        String lastname3 = "IvanovThird";
        double salary3 = 95000;

        String firstname4 = "Ivan";
        String lastname4 = "IvanovFourth";
        double salary4 = 105000;

        //Подготовка ожидаемого результата
        String expectedMessage = "State of employees is full!";

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        employeeService.add(firstname2, lastname2, departmentId, salary2);
        employeeService.add(firstname3, lastname3, departmentId, salary3);

        Exception exception = assertThrows(
                ArrayIsFullException.class,
                () -> employeeService.add(firstname4, lastname4, departmentId, salary4)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void add_withInputDataException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov2";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Input data (firstname or lastname) not correct!";

        //Начало теста
        Exception exception = assertThrows(
                InputDataException.class,
                () -> employeeService.add(firstname, lastname, departmentId, salary)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void add_withEmployeeAlreadyAddedException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Ivan Ivanov has already added!";

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        Exception exception = assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.add(firstname, lastname, departmentId, salary)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_success() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstname, lastname, departmentId, salary);

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        Employee actualEmployee = employeeService.remove(firstname, lastname);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void remove_withInputDataException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov2";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Input data (firstname or lastname) not correct!";

        //Начало теста
        Exception exception = assertThrows(
                InputDataException.class,
                () -> employeeService.remove(firstname, lastname)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove_withEmployeeNotFoundException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        String lastnameToRemove = "Petrov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Can't remove Ivan Petrov. Employee not found!";

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.remove(firstname, lastnameToRemove)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void find_success() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstname, lastname, departmentId, salary);

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        Employee actualEmployee = employeeService.find(firstname, lastname);
        assertEquals(expectedEmployee, actualEmployee);
    }
    @Test
    void find_withInputDataException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov2";

        //Подготовка ожидаемого результата
        String expectedMessage = "Input data (firstname or lastname) not correct!";

        //Начало теста
        Exception exception = assertThrows(
                InputDataException.class,
                () -> employeeService.find(firstname, lastname)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void find_withEmployeeNotFoundException() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        String lastnameToFind = "Petrov";
        double salary = 75000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Can't remove Ivan Petrov. Employee not found!";

        //Начало теста
        employeeService.add(firstname, lastname, departmentId, salary);
        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.remove(firstname, lastnameToFind)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void dataList_success() {
        //Подготовка входных данных
        String firstname = "Ivan";
        String lastname = "Ivanov";
        double salary = 75000;
        int departmentId = 1;

        String firstname2 = "Ivan";
        String lastname2 = "Ivanovsecond";
        double salary2 = 105000;
        int departmentId2 = 2;

        String firstname3 = "Ivan";
        String lastname3 = "Ivanovthird";
        double salary3 = 65000;
        int departmentId3 = 1;

        Employee employee = new Employee(firstname, lastname, departmentId, salary);
        Employee employee2 = new Employee(firstname2, lastname2, departmentId2, salary2);
        Employee employee3 = new Employee(firstname3, lastname3, departmentId3, salary3);

        //Подготовка ожидаемого результата
        Collection<Employee> expectedList = Arrays.asList(employee, employee2, employee3);

        //Начало теста
        employeeService.add(employee);
        employeeService.add(employee2);
        employeeService.add(employee3);
        Collection<Employee> actualList = employeeService.dataList();

        assertTrue(expectedList.containsAll(actualList) && actualList.containsAll(expectedList));
    }

}