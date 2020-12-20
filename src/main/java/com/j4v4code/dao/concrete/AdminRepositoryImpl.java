package com.j4v4code.dao.concrete;

import com.j4v4code.dao.abstr.AdminRepository;
import com.j4v4code.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Admin> getAllUser() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Admin> criteriaQuery = criteriaBuilder.createQuery(Admin.class);
        Root<Admin> rootEntry = criteriaQuery.from(Admin.class);
        CriteriaQuery<Admin> admins = criteriaQuery.select(rootEntry);
        TypedQuery<Admin> adminTypedQuery = getCurrentSession().createQuery(admins);
        return (List<Admin>) adminTypedQuery;
    }

    @Override
    public Admin findByUserName(String userName) {
        CriteriaBuilder criteriaBuilder=getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Admin> criteriaQuery=criteriaBuilder.createQuery(Admin.class);
        Root<Admin> root=criteriaQuery.from(Admin.class);
        Predicate predicateUserName=criteriaBuilder.equal(root.get("userName"),userName);
        criteriaQuery.select(root).where(predicateUserName);

        Query<Admin> query=getCurrentSession().createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
