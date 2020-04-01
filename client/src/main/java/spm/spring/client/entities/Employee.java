package spm.spring.client.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @JsonView(EmployeeViews.Normal.class)
    private Long id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @Column(name = "NAME", length = 50, nullable = false)
    @JsonView(EmployeeViews.Normal.class)
    private String name;

    @Column(name = "DEPARTMENT", length = 50, nullable = false)
    @JsonView(EmployeeViews.Normal.class)
    private String department;

    @Column(name = "LOGIN_TIME", nullable = false)
    @JsonView(EmployeeViews.Manager.class)
    private Long loginTime;

    @Column(name = "LOGOUT_TIME", length = 50, nullable = false)
    @JsonView(EmployeeViews.Manager.class)
    private Long logoutTime;

    @Column(name = "SALARY", length = 10, nullable = false)
    @JsonView(EmployeeViews.HR.class)
    private Long salary;

    @Column(name = "LAST_PROMOTION_DATE", length = 50, nullable = false)
    @JsonView(EmployeeViews.HR.class)
    private Date lastPromotionDate;

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public Long getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Long logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getLastPromotionDate() {
        return lastPromotionDate;
    }

    public void setLastPromotionDate(Date lastPromotionDate) {
        this.lastPromotionDate = lastPromotionDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", salary=" + salary +
                ", lastPromotionDate=" + lastPromotionDate +
                '}';
    }
}
