package com.agapov.buhuchet.service;

import com.agapov.buhuchet.domain.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeGenerator {
    public static final String FIRSTNAME1 = "Ivan";
    public static final String LASTNAME1 = "Ivanov";
    public static final double SALARY1 = 75000.0;
    public static final String FIRSTNAME2 = "Ivan";
    public static final String LASTNAME2 = "Ivanovsecond";
    public static final double SALARY2 = 90000.0;
    public static final String FIRSTNAME3 = "Ivan";
    public static final String LASTNAME3 = "Ivanovthird";
    public static final double SALARY3 = 105000.0;
    public static final int FIRST_DEPARTMENT_ID = 1;
    public static final int SECOND_DEPARTMENT_ID = 2;

    public static Employee getEmployee1() {
        return new Employee(FIRSTNAME1, LASTNAME1, FIRST_DEPARTMENT_ID, SALARY1);
    }

    public static Employee getEmployee2() {
        return new Employee(FIRSTNAME2, LASTNAME2, FIRST_DEPARTMENT_ID, SALARY2);
    }

    public static Employee getEmployee3() {
        return new Employee(FIRSTNAME1, LASTNAME1, SECOND_DEPARTMENT_ID, SALARY3);
    }

    public static List<Employee> getAllEmployee() {
        return Arrays.asList(getEmployee1(), getEmployee2(), getEmployee3());
    }
}
