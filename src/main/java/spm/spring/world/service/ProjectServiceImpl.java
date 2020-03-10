package spm.spring.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import spm.spring.world.dao.IProjectDao;
import spm.spring.world.dto.Project;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements IProjectService{

    @Autowired
    private IProjectDao daoRef;

    @Override
    public List<Project> getProjectList(int empId) {
        // TODO Auto-generated method stub
        System.out.println("in Dao class employee id"+empId);
        return daoRef.findByEmployeeEmpId(empId);
    }

    @Override
    public Project getProjectById(int id) {
        // TODO Auto-generated method stub
        return daoRef.getOne(id);
    }

    @Override
    public void addProject(Project proj) {
        // TODO Auto-generated method stub
        daoRef.save(proj);
    }

    @Override
    public void updateProj(Project proj) {
        // TODO Auto-generated method stub
        daoRef.save(proj);
    }

    @Override
    public void deleteProjectById(int id) {
        // TODO Auto-generated method stub
        daoRef.deleteById(id);
    }

    @Override
    public List<Project> getAllProject() {

        return daoRef.findAll();
    }


}