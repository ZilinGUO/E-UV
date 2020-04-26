package com.rmc.dao;


import com.rmc.po.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SubjectDao extends BaseDao<SubjectDao> {
    private static final String GET_SUBJECT_LISTS_ = "from Subject s where s.project.projectId = ?";
    public List<Subject> getSubjectByProjectId(int projectId){

        List<Subject> subjects = (List<Subject>)getHibernateTemplate().find(GET_SUBJECT_LISTS_,projectId);
        if(subjects.size()==0){
            return null;
        }else{
            return subjects;
        }
    }
}
