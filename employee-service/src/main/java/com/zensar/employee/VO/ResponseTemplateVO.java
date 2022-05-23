package com.zensar.employee.VO;

import com.zensar.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class ResponseTemplateVO {

    private Employee employee;
    private Department department;
	public ResponseTemplateVO(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public ResponseTemplateVO() {
		super();
	}
	public Employee getUser() {
		return employee;
	}
	public void setUser(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [user=" + employee + ", department=" + department + "]";
	}
    
    
}
