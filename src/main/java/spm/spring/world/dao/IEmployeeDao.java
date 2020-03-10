package spm.spring.world.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spm.spring.world.dto.Employee;

import java.util.List;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Integer> {
    List<Employee> findByDepartment(String department);
}
