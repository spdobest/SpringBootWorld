package spm.spring.world.dto;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private  int empId;
    @Column(name="empName")
    private String empName;
    @Column(name="department")
    private String department;
    @Column(name="salary")
    private String salary;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employee(int empId, String empName, String department, String salary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
        super();
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
