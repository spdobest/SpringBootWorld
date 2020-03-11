package spm.spring.world.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spm.spring.world.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}