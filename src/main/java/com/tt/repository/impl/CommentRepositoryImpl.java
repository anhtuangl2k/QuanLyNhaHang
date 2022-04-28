/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.Comment;
import com.tt.repository.CommentRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class CommentRepositoryImpl implements CommentRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Comment> getCommentsByCompanyid(int id, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query =  builder.createQuery(Comment.class);
        Root root = query.from(Comment.class);
        
        query = query.where(builder.equal(root.get("employer"), id));
        query = query.orderBy(builder.desc(root.get("idComment")));
        
        Query q = session.createQuery(query);
        
        int max = 2;
        q.setMaxResults(max);
        q.setFirstResult((page-1)*max);
        return q.getResultList();
    }

    @Override
    public Comment addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            session.save(c);
            
            return c;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
    
}
