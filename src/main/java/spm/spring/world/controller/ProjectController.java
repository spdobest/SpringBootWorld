package spm.spring.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spm.spring.world.dto.Employee;
import spm.spring.world.dto.Project;
import spm.spring.world.service.IProjectService; 

import java.util.List;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectController {

    @Autowired
    private IProjectService serviceProj;


    @RequestMapping("/employees/{empId}/projects")
    public List<Project> getAllProjects(@PathVariable int empId) {
        System.out.println("in Project Controller");
        List<Project> projList = serviceProj.getProjectList(empId);
        System.out.println(projList);
        return projList;
    }

    @RequestMapping("/projects")
    public List<Project> getProjectList(){
        return serviceProj.getAllProject();
    }

    @RequestMapping("/employees/{empid}/projects/{id}")
    public Project getProjectById(@PathVariable int id) {
        return serviceProj.getProjectById(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/employees/{empId}/projects")
    public void addProject(@RequestBody Project proj, @PathVariable int empId) {
        proj.setEmployee(new Employee(empId,"","",""));
        serviceProj.addProject(proj);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/{empId}/projects/{id}")
    public void updateProject(@RequestBody Project proj, @PathVariable int empId) {
        proj.setEmployee(new Employee(empId,"","",""));
        serviceProj.updateProj(proj);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/projects/{id}")
    public void deleteProjectById(@PathVariable int id) {
        serviceProj.deleteProjectById(id);
    }
}
