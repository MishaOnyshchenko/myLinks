package com.links.service;

import com.links.controller.LinkController;
import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.dao.repository.LinkRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LinkService {

    static final Logger log = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private LinkRepository linkRepository;

//    List<LinkEntity> linkEntityList = new ArrayList<>();
//    List<CategoryEntity> categoryEntityList = new ArrayList<>();


    public List<LinkEntity> allLinks() {
//        updateLinkEntityList();
//        log.info("***LinkList*** = " + linkEntityList.toString());
//        return linkEntityList;
        log.info("***LinkList*** = " + linkRepository.linkList().toString());
        return linkRepository.linkList();
    }

    public List<CategoryEntity> allCategories() {
//        updateCategoryEntityList();
//        log.info("***CategoryList*** = " + categoryEntityList.toString());
//        return categoryEntityList;
        log.info("***CategoryList*** = " + linkRepository.categoryList().toString());
        return linkRepository.categoryList();
    }


//    public List<LinkEntity> updateLinkEntityList() {
//       return linkEntityList = linkRepository.linkList();
//    }
//    public void updateCategoryEntityList() {
//        categoryEntityList = linkRepository.categoryList();
//    }


    public void addLink(LinkEntity linkEntity, String category) {

//        CategoryEntity categoryEntity = linkRepository.categoryList().get(0);
//        linkEntity.setCategoryEntity(categoryEntity);
//        System.out.println("@@@@@@@@@@ category " + categoryEntity + "added to " + linkEntity);
        System.out.println("IN ADDLINK");

        CategoryEntity categoryEntity = new CategoryEntity();

        for (CategoryEntity c: linkRepository.categoryList()) {
            if(c.getName().equals(category)){
                categoryEntity = c;
            }
        }
        System.out.println("category from repository!!!!!!!!!!! +++++++++++ " + categoryEntity);

        linkEntity.setCategoryEntity(categoryEntity);

        linkRepository.addLink(linkEntity);
        log.info("****** Link was sent to a repository: " + linkEntity);

    }

    public void addCategory(CategoryEntity categoryEntity) {
        linkRepository.addCategory(categoryEntity);
        log.info("the folder was sent to a repository: " + categoryEntity);
//        updateCategoryEntityList();
    }


    public void deleteLink(LinkEntity linkEntity) {
        for (LinkEntity entity : linkRepository.linkList()) {
            if (entity.getName().equals(linkEntity.getName())) {
                linkRepository.deleteLinkByName(entity);

                log.info(entity + " has sent for deleting");
//                updateLinkEntityList();
            }
        }
    }

    public void deleteCategory(CategoryEntity categoryEntity) {
        for (CategoryEntity entity: linkRepository.categoryList()) {
            if (entity.getName().equals(categoryEntity.getName())) {
                linkRepository.deleteCategoryByName(entity);

                log.info(entity + " has sent for deleting");
//                updateCategoryEntityList();
            }
        }
    }
}
