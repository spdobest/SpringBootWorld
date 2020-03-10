package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.model.Alien;
import spm.spring.world.model.Student;
import spm.spring.world.repository.AlienRepo;
import spm.spring.world.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlienService {

    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    AlienRepo repository;

    // Save student entity in the h2 database.
    public void save(final Alien student) {
        repository.save(student);
    }

    // Get all students from the h2 database.
    public List<Alien> getAllAlien() {
        final List<Alien> students = new ArrayList<>();
        repository.findAll().forEach(student -> students.add(student));
        return students;
    }
}