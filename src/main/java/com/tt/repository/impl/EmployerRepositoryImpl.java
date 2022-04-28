/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.Employer;
import com.findingcareer.pojo.Employer_;
import com.findingcareer.pojo.RatingCompany;
import com.findingcareer.pojo.RatingCompany_;
import com.findingcareer.pojo.MostLikedCompany;
import com.findingcareer.pojo.MostLikedCompany_;
import com.tt.repository.EmployerRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import javax.persistence.Query;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
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
public class EmployerRepositoryImpl implements EmployerRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addEmployer(Employer e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(e);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateEmployer(Employer e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        if (!e.getCompanyName().isEmpty() && !e.getAddress().isEmpty()
                && !e.getDescription().isEmpty() && !e.getOrientation().isEmpty()
                && !e.getPhoneNumber().isEmpty()) {
            String query = "UPDATE Employer SET companyName=:a, phoneNumber=:b, orientation=:c,"
                    + "description=:d, address=:f, email=:g, logo=:i,"
                    + "companyImg=:j WHERE idEmployer=:id ";
            javax.persistence.Query q = session.createQuery(query);
            q.setParameter("a", e.getCompanyName());
            q.setParameter("b", e.getPhoneNumber());
            q.setParameter("c", e.getOrientation());
            q.setParameter("d", e.getDescription());
            q.setParameter("f", e.getAddress());
            q.setParameter("id", e.getIdEmployer());
            q.setParameter("g", e.getEmail());
            q.setParameter("i", e.getLogo());
            q.setParameter("j", e.getCompanyImg());

            q.executeUpdate();

            return true;
        }
        return false;
    }

    @Override
    public Employer getEmployerById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Employer.class, id);
    }

    @Override
    public List<Object[]> getListEmployerByName(String kw, int page, int state) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Employer> rootE = query.from(Employer.class);
        ListJoin<Employer, RatingCompany> ratings = rootE.join(Employer_.listRatings, JoinType.INNER);

        query.where(builder.equal(rootE.get(Employer_.idEmployer), ratings.get(RatingCompany_.employer)));

        query.multiselect(rootE.get(Employer_.idEmployer), rootE.get(Employer_.companyName),
                rootE.get(Employer_.email), rootE.get(Employer_.address), rootE.get(Employer_.phoneNumber),
                rootE.get(Employer_.orientation), rootE.get(Employer_.logo),
                builder.avg(ratings.get(RatingCompany_.star)), rootE.get(Employer_.active));

        if (kw != null && state == 1) {
            Predicate p = builder.like(rootE.get(Employer_.companyName).as(String.class),
                    String.format("%%%s%%", kw));
            Predicate pstate = builder.equal(rootE.get(Employer_.active), state);

            query = query.where(builder.and(p, pstate));
        }
        query = query.groupBy(rootE.get(Employer_.idEmployer));
        query = query.orderBy(builder.desc(rootE.get(Employer_.idEmployer)));

        Query q = session.createQuery(query);

        int max = 4;
        q.setMaxResults(max);

        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public long countEmployer() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Query q = session.createQuery("Select Count(*) from Employer");

        return Long.parseLong(q.getSingleResult().toString());
    }
    
    @Override
    public List<Object[]> getFavoriteCompanies() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Employer> rootE = query.from(Employer.class);
        ListJoin<Employer, MostLikedCompany> mostlikeds = rootE.join(Employer_.mostLikeds, JoinType.INNER);

        query.where(builder.equal(rootE.get(Employer_.idEmployer), mostlikeds.get(MostLikedCompany_.employer)));

        query.multiselect(rootE.get(Employer_.idEmployer), rootE.get(Employer_.companyName),
                rootE.get(Employer_.email), rootE.get(Employer_.address),
                rootE.get(Employer_.phoneNumber), rootE.get(Employer_.logo), rootE.get(Employer_.orientation));
        
        query = query.groupBy(rootE.get(Employer_.idEmployer));
        query = query.orderBy(builder.desc(builder.count(mostlikeds.get(MostLikedCompany_.heart))));

        Query q = session.createQuery(query);
        
        return q.getResultList();  
    }

    @Override
    public boolean updateEmployerState(Employer emplr) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        if(!emplr.isActive() == false){
            Query q = session.createQuery("UPDATE Employer SET active=:ul WHERE id=:id ");
            q.setParameter("ul", true);
            q.setParameter("id", emplr.getIdEmployer());
            
            q.executeUpdate();
            
            return true;
        }
        
        return false;    }

}
