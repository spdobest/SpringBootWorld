package com.springBoot.restapi.service;

import com.springBoot.restapi.dto.Employee;

import java.util.List;

public interface IEmployeeService {
   List<Employee> getAllEmployee();
   Employee getEmployeeById(int empId);
   void addEmployee(Employee employee);
   void updateEmployee(Employee employee,int empId);
   void deleteEmployee(int empId);
}
