package com.example.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author tanghh
 * @Date 2020/4/6 10:35
 */
@Entity
@Table(name = "bos_user", schema = "test3", catalog = "")
public class BosUserModel implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String isDel="0";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "is_del")
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}
