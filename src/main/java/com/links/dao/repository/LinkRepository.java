package com.links.dao.repository;

import com.links.dao.entity.LinkEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class LinkRepository {


    @Autowired
    private SessionFactory sessionFactory;


    public void fillDatabase(){
        LinkEntity entity = new LinkEntity();
        entity.setName("google");
        entity.setAddress("https://www.google.com.ua");
//        entity.setName("yahoo");
//        entity.setAddress("https://www.yahoo.com");
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
    }

    public List<LinkEntity> linkList() {
//        fillDatabase();
        Session currentSession = sessionFactory.getCurrentSession();
        Query<LinkEntity> theQuery = currentSession.createQuery("from LinkEntity", LinkEntity.class);
        return theQuery.getResultList();
    }


        public String addLink(LinkEntity linkEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(linkEntity);
        return "link added";
    }





//    public LinkEntity LinkByName(String name) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        LinkEntity link = (LinkEntity) currentSession.createQuery("FROM LinkEntity le  WHERE le.name =:name")
//                .setParameter("name", name)
//                .uniqueResult();
//        return link;
//    }


}
