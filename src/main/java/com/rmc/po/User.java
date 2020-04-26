package com.rmc.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User extends BasePO {

    @Id
    @Column(name = "id")
    private int userId;


    @Column(name = "user_name")
    private String userName;


    @Column(name = "password")
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }



    @Column(name = "role")
    private int role;

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
