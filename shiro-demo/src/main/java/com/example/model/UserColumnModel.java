package com.example.model;

import javax.persistence.*;

/**
 * @Author tanghh
 * @Date 2020/5/31 14:06
 */
@Entity
@Table(name = "user_column", schema = "shiro_demo", catalog = "")
public class UserColumnModel {
    private Integer id;
    private Integer columnId;
    private Integer userId;
    private String fieldOpen;
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
    @Column(name = "column_id")
    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }
    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Basic
    @Column(name = "field_open")
    public String getFieldOpen() {
        return fieldOpen;
    }

    public void setFieldOpen(String fieldOpen) {
        this.fieldOpen = fieldOpen;
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
