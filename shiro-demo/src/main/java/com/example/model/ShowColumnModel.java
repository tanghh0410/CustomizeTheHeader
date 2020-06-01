package com.example.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author tanghh
 * @Date 2020/5/28 11:15
 */
@Entity
@Table(name = "show_column", schema = "test3", catalog = "")
public class ShowColumnModel {
  private Integer id;
  private String page;
  private String tableName;
  private String fieldName;
  private String dataBaseName;
  private String entityName;
  private Integer fieldOrder;
  private Integer fieldOpen;
  private Timestamp createTime;
  private Timestamp updateTime;
  private Integer isDel=0;
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
    @Column(name = "page")
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    @Basic
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    @Basic
    @Column(name = "field_name")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    @Basic
    @Column(name = "database_name")
    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }
    @Basic
    @Column(name = "entity_name")
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    @Basic
    @Column(name = "field_order")
    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
    }
    @Basic
    @Column(name = "field_open")
    public Integer getFieldOpen() {
        return fieldOpen;
    }

    public void setFieldOpen(Integer fieldOpen) {
        this.fieldOpen = fieldOpen;
    }
    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    @Basic
    @Column(name = "is_del")
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
