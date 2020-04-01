package spm.spring.client.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spm.spring.client.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
