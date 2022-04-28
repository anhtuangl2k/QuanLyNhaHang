/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.CategoryJob;
import com.tt.repository.CategoryRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<CategoryJob> getListCategory() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CategoryJob> query = builder.createQuery(CategoryJob.class);
        Root root = query.from(CategoryJob.class);
        
        query = query.select(root);
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public CategoryJob getCategoryById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(CategoryJob.class, id);
    }
    
}
