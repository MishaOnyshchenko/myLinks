package com.links.dao.repository;

import com.links.controller.LinkController;
import com.links.dao.entity.Role;
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
public class RoleRepo {

    @Autowired
    private SessionFactory sessionFactory;

    static final Logger log = LoggerFactory.getLogger(LinkController.class);


    public void addRole(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(role);
        log.info("Role added to repository: " + role.toString());
    }

    public Role getRoleById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Role> theQuery = currentSession.createQuery("from Role", Role.class);

        List<Role> roles = theQuery.getResultList();

        Role result = null;
        for (Role r : roles) {
            if (r.getId().equals(id)) {
                result = r;
            }
        }
        return result;
    }

}
