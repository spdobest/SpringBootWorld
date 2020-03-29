package spm.spring.world.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spm.spring.world.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
