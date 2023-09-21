package com.agapov.buhuchet.domain;

import java.util.Objects;

public class Employee {
//    public static int counter;

    private final String firstname;
    private final String lastname;
//    private int salary;
//    private int department;
//    private final int id;


    public Employee(String firstname, String lastname/*, int department, int salary*/) {
        this.firstname = firstname;
        this.lastname = lastname;
//        this.department = department;
//        this.salary = salary;
//        id = counter++;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

//    public int getSalary() {
//        return salary;
//    }
//
//    public int getDepartment() {
//        return department;
//    }

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
                /*&& salary == employee.salary && department == employee.department && id == employee.id*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname/*, salary, department, id*/);
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public void setDepartment(int department) {
//        this.department = department;
//    }
}
