package com.zensar.employee.controller;

import com.zensar.employee.VO.ResponseTemplateVO;
import com.zensar.employee.entity.Employee;
import com.zensar.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveUser(@RequestBody Employee employee) {
        //log.info("Inside saveUser of UserController");
        return employeeService.saveUser(employee);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        //log.info("Inside getUserWithDepartment of UserController");
        return employeeService.getUserWithDepartment(userId);
    }


}
