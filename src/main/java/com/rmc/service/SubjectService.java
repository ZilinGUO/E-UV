package com.rmc.service;

import com.rmc.dao.SubjectDao;
import com.rmc.po.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    private SubjectDao subjectdao;
    @Autowired
    public void setProjectDao(SubjectDao subjectDao){
        this.subjectdao = subjectDao;
    }
    public List<Subject> getAllSubjects(int projectId){
        return subjectdao.getSubjectByProjectId(projectId);
    }
}
