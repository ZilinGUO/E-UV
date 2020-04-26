package com.rmc.dao;
import com.rmc.po.Project;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Date;
import java.util.List;

@Repository
public class ProjectDao extends BaseDao<Project>{
    private static final String GET_PRPJECT_LISTS = "from Project p where p.projectId = ?";
    private static final String GET_PRPJECT = "from Project p  ";


    public Project getPostByName(String projectId){
        List<Project> projects = (List<Project>)getHibernateTemplate().find(GET_PRPJECT_LISTS,projectId);
        if(projects.size()==0){
            return null;
        }else{
            return projects.get(0);
        }
    }
    public List<Project> getallProject(){
        List<Project> projects = (List<Project>)getHibernateTemplate().find(GET_PRPJECT);
        if(projects.size()==0){
            return null;
        }else{
            return projects;
        }
    }

    public Project addProject(String projectName,String description) {
        try {
            Configuration cfg = new Configuration().configure();
        //2.创建SessionFactory对象
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //3.创建session对象
        Session session = sessionFactory.openSession();
        //4.操作实体类
        Project project = new Project();
        project.setDescription(description);
        project.setProjectName(projectName);
        project.setDateStart(new Date());
        //5.开启事务
        Transaction transaction = session.beginTransaction();
        session.save(project);
        //6.提交操作
        transaction.commit();
        //7.关闭资源
        session.close();
        sessionFactory.close();
        System.out.println("新增项目成功");
        return project;
        } catch (HibernateException he) {
            System.err.println (he);
            throw new ExceptionInInitializerError (he);
        }

    }

}
