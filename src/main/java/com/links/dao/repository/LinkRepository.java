package com.links.dao.repository;

import com.links.controller.LinkController;
import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.dao.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        log.info("Link added to repository: " + linkEntity);
    }


    public void addCategory(CategoryEntity categoryEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(categoryEntity);
        log.info("Category added to repository: " + categoryEntity);
    }


    public void deleteLinkByName(LinkEntity linkEntity){
        Session currentSession = sessionFactory.getCurrentSession();
        if(linkEntity != null){
            currentSession.delete(linkEntity);
            log.info("Link deleted from repository: " + linkEntity);
        }
    }


    public void deleteCategoryByName(CategoryEntity categoryEntity){
        Session currentSession = sessionFactory.getCurrentSession();
        if(categoryEntity != null){
            currentSession.delete(categoryEntity);
            log.info("Category deleted from repository: " + categoryEntity);
        }
    }


//    public List<CategoryEntity> findMenuByUsername(String username) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query<CategoryEntity> theQuery = currentSession.createQuery("from CategoryEntity", CategoryEntity.class);
//
//        List<CategoryEntity> categoriesFromRepo = theQuery.getResultList();
//        for (CategoryEntity category : categoriesFromRepo) {
//            if (category.ge){}
//        }
//
//
//        return
//    }

    public List<CategoryEntity> findMenuByUsename(String username) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryEntity> theQuery = currentSession.createQuery("from CategoryEntity", CategoryEntity.class);

        List<CategoryEntity> categoriesFromRepo = theQuery.getResultList();

        List<CategoryEntity> categoriesByUserName = new ArrayList<>();

        for (CategoryEntity category : categoriesFromRepo) {
            if (category.getUserInfo().getUsername().equals(username)){
                categoriesByUserName.add(category);
            }
        }

        log.info("Received categories by username from repository: " + categoriesByUserName);

        return categoriesByUserName;
    }


}
