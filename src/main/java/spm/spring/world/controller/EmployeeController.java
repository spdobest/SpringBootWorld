package spm.spring.world.controller;

import spm.spring.world.dto.Employee;
import spm.spring.world.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService empServiceRef;

    @RequestMapping("/welcome")
    public String welcomeEMployee(){
        return "Welcome Sibaprasad";
    }

    @RequestMapping("/employees")
    public List<Employee> getAllEmployee(){
       return  empServiceRef.getAllEmployee();
    }
    @RequestMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int empId){
        return empServiceRef.getEmployeeById(empId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/employees")
    public void addEmployee(@RequestBody Employee employee){
        empServiceRef.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/employees/{empId}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable("empId") int empId){
        empServiceRef.updateEmployee(employee,empId);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        empServiceRef.deleteEmployee(employeeId);
    }

    @RequestMapping("/employees/dept/{department}")
    public List<Employee> getEmployeeByDept(@PathVariable String department){
        return empServiceRef.getEmployeeByDept(department);
    }
}
