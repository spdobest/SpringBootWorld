package spm.spring.world.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import spm.spring.world.entities.Employee;
import spm.spring.world.entities.EmployeeViews;
import spm.spring.world.exceptions.EmployeeExistsException;
import spm.spring.world.exceptions.EmployeeNotFoundException;
import spm.spring.world.restservice.EmployeeService;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/jsonview/employees")
public class EmployeeJsonViewController {

    @Autowired
    private EmployeeService employeeService;


    //getAllUsers method
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    // create user method
    // @RequestBody Annotation
    // @PostMapping Annotation
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody Employee employee, UriComponentsBuilder builder) {
        try {
            employeeService.createEmployee(employee);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/user/{id}").buildAndExpand(employee.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (EmployeeExistsException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    // getEmployeeById - normal
    @JsonView(EmployeeViews.Normal.class)
    @GetMapping("/normal/{id}")
    public Optional<Employee> getEmployeeById1(@PathVariable @Min(1) Long id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (EmployeeNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // getEmployeeById - normal
    @JsonView(EmployeeViews.Manager.class)
    @GetMapping("/manager/{id}")
    public Optional<Employee> getEmployeeById2(@PathVariable @Min(1) Long id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (EmployeeNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // getEmployeeById - normal
    @JsonView(EmployeeViews.HR.class)
    @GetMapping("/hr/{id}")
    public Optional<Employee> getEmployeeById3(@PathVariable @Min(1) Long id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (EmployeeNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // create user method
    // @PathVariable Annotation
    // @PutMapping Annotation
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable("id") @Min(1) Long id, @RequestBody Employee employee) {
        try {
            return employeeService.updateEmployeeByEmployeeId(id, employee);
        } catch (EmployeeNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    // create user method
    // @PathVariable Annotation
    // @DeleteMapping Annotation
    @DeleteMapping("/{id}")
    public String deleteEmployeeByUserId(@PathVariable @Min(1) Long id) {
        try {
            return employeeService.deleteEmployeeByEmployeeId(id);
        } catch (EmployeeNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}

