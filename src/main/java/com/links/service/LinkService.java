package com.links.service;

import com.links.controller.LinkController;
import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.dao.repository.LinkRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Data
@Transactional
@Service
public class LinkService {

    static final Logger log = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private LinkRepository linkRepository;


    public List<LinkEntity> allLinks() {
        return linkRepository.linkList();
    }

    public List<CategoryEntity> allCategories() {
        return linkRepository.categoryList();
    }


    public void addLink(LinkEntity linkEntity, String category) {
        CategoryEntity categoryEntity = new CategoryEntity();

        for (CategoryEntity c : linkRepository.categoryList()) {
            if (c.getName().equals(category)) {
                categoryEntity = c;
            }
        }
        log.info("Category received by its name from repository for adding to linkEntity in service : " + categoryEntity);

        linkEntity.setCategoryEntity(categoryEntity);

        linkRepository.addLink(linkEntity);
        log.info("LinkEntity with added category was sent for saving to repository: " + linkEntity);
    }


    public void addCategory(CategoryEntity categoryEntity) {
        linkRepository.addCategory(categoryEntity);
        log.info("Category was sent for saving from service to repository: " + categoryEntity);
    }


    public List<LinkEntity> showLinksByCategory(String category) {
        List<LinkEntity> linkEntityList = new LinkedList<>();

        for (CategoryEntity c : linkRepository.categoryList()) {
            if(c.getName().equals(category)){
                linkEntityList = c.getLinkEntityList();
            }
        }
        log.info("List of the Links received from repository to service and will be returned to controller: " + linkEntityList);
        return linkEntityList;
    }

    public void deleteLink(LinkEntity linkEntity) {

        for (LinkEntity entity : linkRepository.linkList()) {
            if (entity.getName().equals(linkEntity.getName())) {
                linkRepository.deleteLinkByName(entity);
                log.info("LinkEntity was sent from service to repository for deleting: " + entity);
            }
        }
    }


    public void deleteCategory(CategoryEntity categoryEntity) {

        for (CategoryEntity entity : linkRepository.categoryList()) {
            if (entity.getName().equals(categoryEntity.getName())) {
                linkRepository.deleteCategoryByName(entity);
                log.info("CategoryEntity was sent from service to repository for deleting: " + entity);
            }
        }
    }
}
