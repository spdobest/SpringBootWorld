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

    List<Employee> empList1 = Arrays.asList(new Employee(1,"Siba","It"),
               new Employee(100,"Satya","It"),
               new Employee(101,"Silu","It"),
               new Employee(102,"Dipu","It"),
               new Employee(103,"Amit","It"),
               new Employee(104,"Sachin","It"),
               new Employee(105,"Naresh","It"),
               new Employee(106,"Bhushan","It"),
               new Employee(107,"Dinesh","It"),
               new Employee(108,"Prasad","It"),
               new Employee(109,"Jayesh","It"),
               new Employee(110,"Kishor","It"));

    List<Employee> empList = new ArrayList<>(empList1);

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

       /* for(int i = 0;i<empList.size();i++){
            Employee e = empList.get(i);
            if(e.getEmpId() == empId){
                empList.set(i,employee);
            }
        }*/

        iEmployeeDao.save(employee);

    }

    @Override
    public void deleteEmployee(int empId) {
//        empList.removeIf(e -> e.getEmpId() == empId);
        iEmployeeDao.deleteById(empId);
    }
}
