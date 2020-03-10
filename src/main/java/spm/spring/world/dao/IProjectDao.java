package spm.spring.world.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spm.spring.world.dto.Project;

import java.util.List;

public interface IProjectDao extends JpaRepository<Project,Integer> {
    List<Project> findByEmployeeEmpId(int empId);
}
