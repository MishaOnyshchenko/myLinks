package com.links.dao.repository;

import com.links.controller.LinkController;
import com.links.dao.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepo {

    @Autowired
    private SessionFactory sessionFactory;

    static final Logger log = LoggerFactory.getLogger(LinkController.class);


    public void saveUser(UserInfo userInfo) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userInfo);
        log.info("User added to repository: " + userInfo.toString());
    }

    public UserInfo findByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UserInfo> theQuery = currentSession.createQuery("from UserInfo", UserInfo.class);
        List<UserInfo> usersFromRepo = theQuery.getResultList();
        UserInfo result = null;
        for (UserInfo user : usersFromRepo) {
            if (user.getUsername().equals(username)) {
                result = user;
            }
        }
        return result;
    }
}
