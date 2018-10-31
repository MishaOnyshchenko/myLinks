package com.links.dao.repository;

import com.links.controller.LinkController;
import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
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
public class LinkRepository {

    static final Logger log = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private SessionFactory sessionFactory;


    public List<LinkEntity> linkList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<LinkEntity> theQuery = currentSession.createQuery("from LinkEntity", LinkEntity.class);
        return theQuery.getResultList();
    }

    public List<CategoryEntity> categoryList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryEntity> theQuery = currentSession.createQuery("from CategoryEntity", CategoryEntity.class);
        return theQuery.getResultList();
    }


    public void addLink(LinkEntity linkEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(linkEntity);
        log.info("link added: " + linkEntity);
    }

    public void addCategory(CategoryEntity categoryEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(categoryEntity);
        log.info("link added: " + categoryEntity);
    }


    public void deleteLinkByName(LinkEntity linkEntity){
        Session currentSession = sessionFactory.getCurrentSession();
        if(linkEntity != null){
            currentSession.delete(linkEntity);
            log.info(linkEntity + " deleted");
        }
    }

    public void deleteCategoryByName(CategoryEntity categoryEntity){
        Session currentSession = sessionFactory.getCurrentSession();
        if(categoryEntity != null){
            currentSession.delete(categoryEntity);
            log.info(categoryEntity + " deleted");
        }
    }





//    public String deleteAll() {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.delete();
//        return "all deleted";
//    }

//    public LinkEntity LinkByName(String name) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        LinkEntity link = (LinkEntity) currentSession.createQuery("FROM LinkEntity le  WHERE le.name =:name")
//                .setParameter("name", name)
//                .uniqueResult();
//        return link;
//    }


}
