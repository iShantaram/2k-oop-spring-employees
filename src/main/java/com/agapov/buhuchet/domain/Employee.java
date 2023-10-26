package com.agapov.buhuchet.domain;

import java.util.Objects;
import java.util.Random;

public class Employee {

    private final String firstname;
    private final String lastname;
    private final int department;
    private double salary;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        Random random = new Random();
        this.department = random.nextInt(2) + 1;
        this.salary = random.nextInt(50000) + 50000;
    }

    public Employee(String firstname, String lastname, Integer department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        Random random = new Random();
        this.salary = random.nextInt(50000) + 50000;
    }

    public Employee(String firstname, String lastname, Integer department, Double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + firstname + '\'' + ", lastname='" + lastname /*salary=" + salary + ", department=" + department + ", id=" + id*/ + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstname.equals(employee.firstname) && lastname.equals(employee.lastname)
                && salary == employee.salary && department == employee.department;
    }@Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, salary, department);
    }

    public Integer getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
