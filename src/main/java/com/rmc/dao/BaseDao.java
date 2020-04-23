
package com.rmc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> {
    private Class<T> entityClass;
    private HibernateTemplate hibernateTemplate;

    public BaseDao(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class)params[0];
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public T load(Serializable id){
        return (T) getHibernateTemplate().load(entityClass,id);
    }

    /**
     * 获取PO的所有对象
     *
     * @return
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    public T get(Serializable id){
        return (T) getHibernateTemplate().get(entityClass,id);
    }

    public void save(T entity){
        getHibernateTemplate().save(entity);
    }

    public void delete(T entity){
        getHibernateTemplate().delete(entity);
    }

    public void update(T entity){
        getHibernateTemplate().update(entity);
    }

    public List find(String hql){
        return this.getHibernateTemplate().find(hql);
    }

    public List find(String hql,Object... params){
        return this.getHibernateTemplate().find(hql,params);
    }
}
