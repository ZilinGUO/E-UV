package com.rmc.po;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_subject")
public class Subject extends BasePO {
    @Id
    @Column(name = "subjectId")
    private int subjectId;

    @Column(name = "description")
    private String description;

    @Column(name = "subjectName")
    private String subjectName;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="projectId")
    private Project project;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonBackReference
    public Project getProject() {
        return project;
    }
    @JsonBackReference
    public void setProject(Project project) {
        this.project = project;
    }



    @Override
    public String toString()
    {
        return "Subject [id=" + subjectId +"subjectName"+subjectName+", description=" + description + ", projectId=" + project.getProjectId() + "]";
    }
}
