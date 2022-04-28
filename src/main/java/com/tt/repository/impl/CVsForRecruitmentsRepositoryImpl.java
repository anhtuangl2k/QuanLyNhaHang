/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.CVsForRecruitments;
import com.findingcareer.pojo.CategoryJob;
import com.findingcareer.pojo.Employee;
import com.findingcareer.pojo.Employer;
import com.findingcareer.pojo.Recruitment;
import com.tt.repository.CVsForRecruitmentsRepository;
import java.util.Date;
import java.util.List;
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
public class CVsForRecruitmentsRepositoryImpl implements CVsForRecruitmentsRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addCV(CVsForRecruitments cv) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(cv);
            
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean updateState(CVsForRecruitments cv) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        if (!cv.getState().isEmpty()) {
            Query q = session.createQuery("UPDATE CVsForRecruitments SET state=:ul WHERE id=:id");
            q.setParameter("ul", cv.getState());
            q.setParameter("id", cv.getId());
            
            q.executeUpdate();
            
            return true;
        }
        
        return false;
    }
    
    @Override
    public List<Object> getListCVByEmployer(int idEmployer, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootR = query.from(Recruitment.class);
        Root rootE = query.from(Employee.class);
        Root rootC = query.from(CVsForRecruitments.class);
        
        Predicate p = builder.equal(rootE.get("idEmployee"), rootC.get("employee"));
        Predicate pc = builder.equal(rootR.get("idRecruitment"), rootC.get("recruitment"));
        Predicate pid = builder.equal(rootC.get("employer"), idEmployer);
        
        query.multiselect(rootR.get("title"), rootC.get("cv"),
                rootE.get("phoneNumber"), rootC.get("id"), rootC.get("state"));
        query = query.where(builder.and(p, pc, pid));
        
        query = query.orderBy(builder.desc(rootC.get("id")));
        
        Query q = session.createQuery(query);
        
        int max = 4;
        q.setMaxResults(max);
        
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }
    
    @Override
    public long countCvsByEmployer(Employer emp) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Query q = session.createQuery(""
                + "Select Count(*) from CVsForRecruitments c where c.employer=:id");
        
        q.setParameter("id", emp);
        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
    @Override
    public CVsForRecruitments getCVById(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(CVsForRecruitments.class, i);        
    }
    
    @Override
    public List<Object> staticCV(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootR = query.from(Recruitment.class);
        Root rootC = query.from(CategoryJob.class);
        Root rootCV = query.from(CVsForRecruitments.class);
        
        Predicate pc = builder.equal(rootC.get("idCategory"), rootR.get("categoryJob"));
        Predicate pcv = builder.equal(rootR.get("idRecruitment"), rootCV.get("recruitment"));

        query.multiselect(rootR.get("idRecruitment"), rootR.get("title"), rootC.get("nameJob"),
                 builder.count(rootCV.get("cv")));
        
        Predicate pfrom = builder.greaterThanOrEqualTo(rootCV.get("createdDate"), fromDate);
        Predicate pto = builder.lessThanOrEqualTo(rootCV.get("createdDate"), toDate);

        query = query.where(builder.and(pc, pcv, pfrom, pto));
        query = query.groupBy(rootC.get("idCategory"));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
