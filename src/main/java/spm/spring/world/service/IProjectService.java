package spm.spring.world.service;

import spm.spring.world.dto.Project;

import java.util.List;
import java.util.Optional;

import java.util.List;


public interface IProjectService {

    List<Project> getProjectList(int empId);

    Project getProjectById(int id);

    void addProject(Project proj);

    void updateProj(Project proj);

    void deleteProjectById(int id);

    List<Project> getAllProject();
}