package com.rmc.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_post")
public class Post extends BasePO {

    @Id
    @Column(name = "id")
    private int postId;

    @Id
    @Column(name = "post_name")
    private String postName;

    @Id
    @Column(name = "content")
    private String content;

    public void setPostid(int id){
        postId = id;
    }

    public int getPostid() {
        return postId;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostName() {
        return postName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}