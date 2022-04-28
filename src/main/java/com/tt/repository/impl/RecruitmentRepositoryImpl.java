/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.repository.impl;

import com.findingcareer.pojo.CategoryJob;
import com.findingcareer.pojo.Employer;
import com.findingcareer.pojo.Recruitment;
import com.findingcareer.pojo.Recruitment_;
import com.findingcareer.pojo.MostLikedRecruitment;
import com.findingcareer.pojo.MostLikedRecruitment_;
import com.tt.repository.RecruitmentRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
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
public class RecruitmentRepositoryImpl implements RecruitmentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object> getListRecruitmentByCondition(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootR = query.from(Recruitment.class);
        Root rootE = query.from(Employer.class);
        Root rootC = query.from(CategoryJob.class);

        Predicate p = builder.equal(rootE.get("idEmployer"), rootR.get("employer"));
        Predicate pc = builder.equal(rootC.get("idCategory"), rootR.get("categoryJob"));

        query.multiselect(rootR.get("idRecruitment"), rootR.get("title"),
                rootR.get("salary"), rootR.get("position"), rootR.get("experience"),
                rootR.get("now"), rootE.get("companyName"), rootE.get("address"),
                rootC.get("nameJob"), rootE.get("phoneNumber"));
        if (kw != null) {
            if (kw.contains("-")) {
                String[] l = kw.split("-");
                if (Integer.parseInt(l[0]) == 0 && Integer.parseInt(l[1]) == 0) {
                    Predicate s = builder.equal(rootR.get("salary").as(BigDecimal.class), 0);

                    query = query.where(builder.and(pc, p, s));

                } else {
                    Predicate s = builder.between(rootR.get("salary").as(BigDecimal.class),
                            Integer.parseInt(l[0]), Integer.parseInt(l[1]));
                    query = query.where(builder.and(pc, p, s));
                }
            } else if (kw.equals("1")) {
                query = query.where(builder.and(pc, p, builder.equal(rootR.get("now"),
                         Integer.parseInt(kw))));
            } else {
                Predicate p1 = builder.like(rootR.get("title").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p2 = builder.like(rootR.get("position").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p3 = builder.like(rootR.get("salary").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p4 = builder.like(rootR.get("experience").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p5 = builder.like(rootE.get("companyName").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p6 = builder.like(rootE.get("address").as(String.class),
                        String.format("%%%s%%", kw));
                Predicate p7 = builder.like(rootC.get("nameJob").as(String.class),
                        String.format("%%%s%%", kw));

                query = query.where(builder.and(builder.or(p1, p2, p3,
                        p4, p5, p6, p7), p, pc));
            }
        } else {
            query = query.where(builder.and(p, pc));
        }
        query = query.orderBy(builder.desc(rootR.get("idRecruitment")));

        Query q = session.createQuery(query);

        int max = 20;
        q.setMaxResults(max);

        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public Recruitment getRecruitmentById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Recruitment.class, id);
    }

    @Override
    public boolean updateRecruitment(Recruitment r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        if (r.getCategoryJob() != null && !r.getDescription().equals("")
                && !r.getExperience().equals("") && !r.getPosition().equals("")
                && !r.getRequirement().equals("") && !r.getTitle().equals("")
                && !r.getWelfare().equals("")) {
            String query = "UPDATE Recruitment SET title=:a, welfare=:b, description=:c,"
                    + "requirement=:d, position=:e, experience=:f, salary=:g, now=:h, categoryJob=:i"
                    + " WHERE idRecruitment=:id ";
            Query q = session.createQuery(query);
            q.setParameter("a", r.getTitle());
            q.setParameter("b", r.getWelfare());
            q.setParameter("c", r.getDescription());
            q.setParameter("d", r.getRequirement());
            q.setParameter("e", r.getPosition());
            q.setParameter("f", r.getExperience());
            q.setParameter("g", r.getSalary());
            q.setParameter("h", r.isNow());
            q.setParameter("i", r.getCategoryJob());
            q.setParameter("id", r.getIdRecruitment());

            q.executeUpdate();

            return true;
        }

        return false;
    }

    @Override
    public boolean addRecruitment(Recruitment r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(r);
            return true;
        } catch (HibernateException ex) {
            System.err.println("MESSAGE HERE = " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteRecruitment(Recruitment r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(r);
            return true;
        } catch (HibernateException ex) {
            System.err.println("MESSAGE HERE = " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Recruitment> getAmountRecruitmentByCompany(int id, int index) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recruitment> query = builder.createQuery(Recruitment.class);
        Root root = query.from(Recruitment.class);

        query = query.where(builder.equal(root.get("employer"), id));
        query = query.orderBy(builder.desc(root.get("idRecruitment")));

        Query q = session.createQuery(query);

        int max = 2;
        q.setMaxResults(max);
        q.setFirstResult(index);
        return q.getResultList();

    }

    @Override
    public long countRes() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Query q = session.createQuery("Select Count(*) from Recruitment");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Object[]> getFavoriteRecruitments() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Recruitment> rootE = query.from(Recruitment.class);
        ListJoin<Recruitment, MostLikedRecruitment> mostlikeds = rootE.join(Recruitment_.mostLikeds, JoinType.INNER);

        query.where(builder.equal(rootE.get(Recruitment_.idRecruitment), mostlikeds.get(MostLikedRecruitment_.recruitment)));

        query.multiselect(rootE.get(Recruitment_.idRecruitment), rootE.get(Recruitment_.title),
                rootE.get(Recruitment_.salary), rootE.get(Recruitment_.position));

        query = query.groupBy(rootE.get(Recruitment_.idRecruitment));
        query = query.orderBy(builder.desc(builder.count(mostlikeds.get(MostLikedRecruitment_.heart))));

        Query q = session.createQuery(query);

        return q.getResultList();
    }

}
