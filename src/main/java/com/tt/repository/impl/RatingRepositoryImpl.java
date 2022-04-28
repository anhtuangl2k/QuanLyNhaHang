/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.RatingCompany;
import com.tt.repository.RatingRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class RatingRepositoryImpl implements RatingRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addRating(RatingCompany r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            session.save(r);
            
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        
        return false; 
    }

    @Override
    public RatingCompany getRatingByEmployee(int idEmployee, int idEmployer) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RatingCompany> query =  builder.createQuery(RatingCompany.class);
        Root root = query.from(RatingCompany.class);
        
        
        Predicate p1 = builder.equal(root.get("employee"), idEmployee);
        Predicate p2 = builder.equal(root.get("employer"), idEmployer);
        
        query = query.where(builder.and(p1,p2));
        
        RatingCompany r = session.createQuery(query).uniqueResult();    
        
        return r; 
    }

    @Override
    public Object getAverageRatingCompany(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query =  builder.createQuery(Object.class);
        Root root = query.from(RatingCompany.class);
        
        query.where(builder.equal(root.get("employer"), id));
        
        query.multiselect(root.get("employer"),builder.avg(root.get("star")));
        query.groupBy(root.get("employer"));
        
        Query q = session.createQuery(query);
        
        return q.getSingleResult();
    }
    
}
