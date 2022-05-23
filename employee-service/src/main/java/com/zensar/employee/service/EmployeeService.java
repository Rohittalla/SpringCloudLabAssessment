package com.zensar.employee.service;

import com.zensar.employee.VO.Department;
import com.zensar.employee.VO.ResponseTemplateVO;
import com.zensar.employee.entity.Employee;
import com.zensar.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveUser(Employee employee) {
        //log.info("Inside saveUser of UserService");
        return employeeRepository.save(employee);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        //log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + employee.getDepartmentId()
                        ,Department.class);

        vo.setUser(employee);
        vo.setDepartment(department);

        return  vo;
    }
}
