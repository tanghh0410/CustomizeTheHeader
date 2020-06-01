package com.example.repository.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.hibernate.SQLQuery;
import org.hibernate.jpa.HibernateQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能描述: <br>
 * 〈〉
 * @Author: tanghh18
 * @Date: 2020/5/28 11:34
 */
public abstract class BaseRepository {

    @PersistenceContext
    protected EntityManager entities;

    protected <T> T getScalar(String sql, Class<T> clazz) {
        return this.getScalar(sql, Maps.newHashMap(), clazz);
    }

    protected <T> T getScalar(String sql, Map params, Class<T> clazz) {
        List list = this.getList(sql, params);
        if (list.size() == 0) {
            return null;
        }

        Map first = (Map) Iterables.get(list, 0);
        if (first.entrySet().size() == 0) {
            return null;
        }

        Map.Entry entry = (Map.Entry) Iterables.get(first.entrySet(), 0);
        return (T) entry.getValue();
    }

    protected List getList(String sqlStr) {
        return this.getList(sqlStr, Maps.newHashMap());
    }

    //查询视图
    protected List getViewCondition(int viewId){
        String sql="SELECT a.*,b.condition_relation from view_condition a LEFT JOIN `view` b on a.vid=b.id WHERE a.vid=:vid";
        Map map=new HashMap();
        map.put("vid",viewId);
        return this.getList(sql,map);
    }

    protected List getList(String sqlStr,int pageSize, int pageIndex) {
        if (pageSize != 0 || pageIndex != 0) {
            sqlStr = String.format("%s limit %d, %d", sqlStr, (pageIndex-1) * pageSize, pageSize);
        }
        return this.getList(sqlStr, Maps.newHashMap());
    }

    protected List getList(String sqlStr, Map params) {
        Query query = this.entities.createNativeQuery(sqlStr);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }
        return this.toMap(query);
    }

    protected List getList(String sqlStr, Class clazz) {
        Query query = this.entities.createNativeQuery(sqlStr, clazz);
        return query.getResultList();
    }

    protected List getList(String sqlStr, Map params, Class clazz) {
        Query query = this.entities.createNativeQuery(sqlStr, clazz);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }
        return query.getResultList();
    }

    protected List getList(String sqlStr, Map params,int pageSize, int pageIndex) {
        if (pageSize != 0 || pageIndex != 0) {
            sqlStr = String.format("%s limit %d, %d", sqlStr, (pageIndex-1) * pageSize, pageSize);
        }
        Query query = this.entities.createNativeQuery(sqlStr);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }
        return this.toMap(query);
    }

    protected List getList(String sqlStr, Map params,int pageSize, int pageIndex,Class clazz) {
        if (pageSize != 0 || pageIndex != 0) {
            sqlStr = String.format("%s limit %d, %d", sqlStr, (pageIndex-1) * pageSize, pageSize);
        }
        Query query = this.entities.createNativeQuery(sqlStr,clazz);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }
        return this.toMap(query);
    }

    protected List getList(String sqlStr,int pageSize, int pageIndex,Class clazz) {
        if (pageSize != 0 || pageIndex != 0) {
            sqlStr = String.format("%s limit %d, %d", sqlStr, (pageIndex-1) * pageSize, pageSize);
        }
        Query query = this.entities.createNativeQuery(sqlStr,clazz);
        return query.getResultList();
    }

    protected int executeUpdate(String sqlStr, Map params) {
        Query query = this.entities.createNativeQuery(sqlStr);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }
        return query.executeUpdate();
    }

    protected int executeUpdate(String sqlStr) {
        Query query = this.entities.createNativeQuery(sqlStr);
        return query.executeUpdate();
    }

    protected List getEntityList(String sqlStr, Map params) {
        Query query = this.entities.createQuery(sqlStr);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }

        return query.getResultList();
    }

    protected int getCount(String sqlStr) {
        return this.getCount(sqlStr, Maps.newHashMap());
    }

    protected int getCount(String sqlStr, Map params) {
        Query query = this.entities.createNativeQuery(sqlStr);
        if (params != null) {
            for (Object key : params.keySet()) {
                query.setParameter((String) key, params.get(key));
            }
        }

        BigInteger result = (BigInteger) query.getSingleResult();
        return result.intValueExact();
    }



    private List toMap(Query query) {
        query.unwrap(org.hibernate.SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    private void addScalar(Query query, String column, Type type) {
        if (query instanceof HibernateQuery) {
            query.unwrap(SQLQuery.class).addScalar(column, type);
        }

        throw new IllegalStateException();
    }
}
