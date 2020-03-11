package spm.spring.world.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.model.Student;
import spm.spring.world.repository.StudentRepository;

@Service
public class StudentService {
 
    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    StudentRepository repository;
 
    // Save student entity in the h2 database.
    public Student save(final Student student) {
        Student st = null;
        if(student!=null){
            if(student.getStudentAge() == 0 && student.getStudentName() == null && student.getStudentEmail() == null){
                st = null;
            }
            else{
                st =  repository.save(student);
            }
        }
        return  st;
    }
 
    // Get all students from the h2 database.
    public List<Student> getAll() {
        final List<Student> students = new ArrayList<>();
        repository.findAll().forEach(student -> students.add(student));
        return students;
    }
}