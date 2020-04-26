package com.rmc.service;

import com.rmc.dao.ProjectDao;
import com.rmc.po.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private ProjectDao projectdao;
    @Autowired
    public void setProjectDao(ProjectDao postDao){
        this.projectdao = postDao;
    }
    public void createProject(String projectName,String description){
        projectdao.addProject(projectName,description);
    }
    public List<Project> getAllProjects(){
        return projectdao.loadAll();
    }
}
