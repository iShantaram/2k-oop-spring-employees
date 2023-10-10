package com.agapov.buhuchet.controller;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @ExceptionHandler(RuntimeException.class)
//    public String handleException(RuntimeException e) {
//        return e.getMessage();
//    }

    @GetMapping
    public String privet() {
        return "Привет.</br>" +
                "Доступны добавление, поиск и удаление сотрудников по имени и фамилии - оба параметра должны быть заданы.</br>" +
                "/add /remove /find</br>" +
                "Также доступна команда вывода всех сотрудников в списке - /list</br>" +
                "Пример:</br>" +
                "/employee/add?firstname=Petr&lastname=Ivanov";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return employeeService.addEmployee(firstname, lastname);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping(path = "/list")
    public Collection<Employee> employeeList() {
        return employeeService.dataList();
    }

}
