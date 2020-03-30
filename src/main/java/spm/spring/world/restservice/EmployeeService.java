package spm.spring.world.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.entities.Employee;
import spm.spring.world.exceptions.EmployeeExistsException;
import spm.spring.world.exceptions.EmployeeNotFoundException;
import spm.spring.world.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //getAllEmployees method
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    // createEmployee Method
    public Employee createEmployee(Employee employee) throws EmployeeExistsException {
        Optional<Employee> EmployeeCreate = employeeRepository.findById(employee.getId());
        if (EmployeeCreate.isPresent()) {
            throw new EmployeeExistsException("Employee already exist, please check the Employee id");
        }
        return employeeRepository.save(employee);
    }

    // getEmployeeById Method
    public Optional<Employee> getEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> Employee = employeeRepository.findById(id);
        if (!Employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not found in Repository");
        }
        return Employee;
    }

    // getEmployeeById Method
    public Employee updateEmployeeByEmployeeId(Long id, Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> updatedUer = employeeRepository.findById(id);
        if (!updatedUer.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not found in Repository,Please provide correct Employee Id");
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    // getEmployeeById Method
    public String deleteEmployeeByEmployeeId(Long id) throws EmployeeNotFoundException {
        Optional<Employee> Employee = employeeRepository.findById(id);
        if (Employee.isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted Successfully";
        } else {
            throw new EmployeeNotFoundException("Employee Not Found, Please provide correct Employee id to delete");
        }
    }

}
