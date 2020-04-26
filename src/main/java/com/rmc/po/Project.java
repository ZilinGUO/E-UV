package com.rmc.po;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "t_project")
public class Project extends BasePO {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "projectId")
    private int projectId;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date dateStart;

    @Column(name = "project_name")
    private String projectName;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="project")
    private Set<Subject> subjects;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    @Override
    public String toString()
    {
        return "Project [id=" + projectId +"projectName"+projectName+", description=" + description + ", dateStart=" + dateStart.toString() + "]";
    }

}

