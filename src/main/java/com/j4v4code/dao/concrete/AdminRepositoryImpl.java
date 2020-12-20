package com.j4v4code.dao.concrete;

import com.j4v4code.dao.abstr.AdminRepository;
import com.j4v4code.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Admin findByUserName(Class clazz, Long id) {
        return (Admin) getCurrentSession().get(clazz,id);
    }
}
