/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.Employee;
import com.findingcareer.pojo.User;
import com.tt.repository.EmployeeRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addEmployee(Employee e) {
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
    public boolean updateEmployee(Employee e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        if (!e.getAvatarUrl().isEmpty() && !e.getAddress().isEmpty()
                && !e.getNationality().isEmpty() && !e.getPhoneNumber().isEmpty()
                && !e.getPosition().isEmpty() && !e.getCompany().isEmpty() 
                && !e.getSubject().isEmpty() && !e.getSchool().isEmpty()
                && !e.getQualification().isEmpty() && !e.getSkill().isEmpty()
                && !e.getLanguage().isEmpty() && e.getSalaryOffer() != null
                && !e.getPositionOffer().isEmpty() && !e.getCv().isEmpty()) {
            String query = "UPDATE Employee SET avatarUrl=:a, phoneNumber=:b, dob=:c,"
                    + "sex=:d, nationality=:e, address=:f, position=:g, company=:h,"
                    + "currentjob=:i, subject=:j, school=:k, qualification=:l, skill=:m,"
                    + "language=:n, salaryOffer=:o, positionOffer=:p, cv=:q WHERE idEmployee=:id ";
            Query q = session.createQuery(query);
            
            q.setParameter("a", e.getAvatarUrl());
            q.setParameter("b", e.getPhoneNumber());
            q.setParameter("c", e.getDob());
            q.setParameter("d", e.isSex());
            q.setParameter("e", e.getNationality());
            q.setParameter("f", e.getAddress());
            q.setParameter("g", e.getPosition());
            q.setParameter("h", e.getCompany());
            q.setParameter("i", e.isCurrentjob());
            q.setParameter("j", e.getSubject());
            q.setParameter("k", e.getSchool());
            q.setParameter("l", e.getQualification());
            q.setParameter("m", e.getSkill());
            q.setParameter("n", e.getLanguage());
            q.setParameter("o", e.getSalaryOffer());
            q.setParameter("p", e.getPositionOffer());
            q.setParameter("q", e.getCv());
            q.setParameter("id", e.getIdEmployee());
            q.executeUpdate();

            return true;
        }
        else{
            System.err.print("null" + e.getAddress());
            return false;
        }
    }

    @Override
    public Employee getEmployeeById(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Employee.class, i);
    }

    @Override
    public List<Object> getListEmployee(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootE = query.from(Employee.class);
        Root rootU = query.from(User.class);
        
        Predicate p = builder.equal(rootE.get("user"), rootU.get("idUser"));
        
        query.multiselect(rootU.get("firstName"),rootU.get("lastName"),
                rootU.get("email"), rootE.get("sex"),rootE.get("phoneNumber"), 
                rootE.get("nationality"), rootE.get("address"),
                rootE.get("qualification"), rootE.get("skill"),
                rootE.get("language"),rootE.get("avatarUrl"), 
                rootE.get("idEmployee"), rootE.get("subject"), 
                rootE.get("salaryOffer"));

        if (kw != null) {
            Predicate p1 = builder.like(rootE.get("nationality").as(String.class), 
                    String.format("%%%s%%", kw));
            Predicate p2 = builder.like(rootE.get("qualification").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p3 = builder.like(rootE.get("skill").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p4 = builder.like(rootE.get("language").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p5 = builder.like(rootE.get("subject").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p6 = builder.equal(rootE.get("salaryOffer").as(String.class),kw);
            
            
            query = query.where(builder.and(builder.or(p1,p2,p3,p4,p5,p6), p));
        }
        else
        {
            query = query.where((p));
        }
        query = query.orderBy(builder.desc(rootE.get("idEmployee")));

        Query q = session.createQuery(query);

        int max = 3;
        q.setMaxResults(max);

        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public Object getDetailsEmployeeById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = builder.createQuery(Object.class);
        Root rootE = query.from(Employee.class);
        Root rootU = query.from(User.class);
        
        Predicate p1 = builder.equal(rootE.get("user"), rootU.get("idUser"));
        Predicate p2 = builder.equal(rootE.get("idEmployee"), id);
        
        query.multiselect(rootU.get("firstName"),rootU.get("lastName"),
                rootU.get("email"), rootE.get("sex"),rootE.get("phoneNumber"), 
                rootE.get("nationality"), rootE.get("subject"), rootE.get("school"),
                rootE.get("qualification"), rootE.get("skill"),
                rootE.get("language"),rootE.get("avatarUrl"), 
                rootE.get("idEmployee"),rootE.get("salaryOffer"), rootE.get("positionOffer"),
                rootE.get("currentjob"), rootE.get("company"));
        
        query.where(builder.and(p1,p2));
        
        Query q = session.createQuery(query);
        
        return q.getSingleResult();
    }
}
