package com.agapov.buhuchet.controller;

import com.agapov.buhuchet.domain.Employee;
import com.agapov.buhuchet.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }


    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployees(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployees(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getAllEmployees();
    }
}
