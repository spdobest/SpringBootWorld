package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import spm.spring.world.dao.IEmployeeDao;
import spm.spring.world.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeDao iEmployeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int empId) {
        //return empList.stream().filter(e -> e.getEmpId() == empId).findFirst().get();
        return iEmployeeDao.getOne(empId);
    }

    @Override
    public void addEmployee(Employee employee) {
       // empList.add(employee);
        iEmployeeDao.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee,int empId) {
        iEmployeeDao.save(employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        iEmployeeDao.deleteById(empId);
    }

    @Override
    public List<Employee> getEmployeeByDept(String department) {
        return iEmployeeDao.findByDepartment(department);
    }
}
