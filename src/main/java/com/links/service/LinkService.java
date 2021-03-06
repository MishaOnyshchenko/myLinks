package com.links.service;

import com.links.controller.LinkController;
import com.links.dao.entity.CategoryEntity;
import com.links.dao.entity.LinkEntity;
import com.links.dao.entity.UserInfo;
import com.links.dao.repository.LinkRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Transactional
@Service
public class LinkService {

    private static final Logger log = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserService userService;


    public List<LinkEntity> allLinks() {

        List<LinkEntity> linkEntityListByUserInfo = new ArrayList<>();

        List<CategoryEntity> categoryEntityListByUserInfo = allCategories();
        log.info("Received categories by username from repository to service: " + categoryEntityListByUserInfo);

        for (CategoryEntity category : categoryEntityListByUserInfo) {
            linkEntityListByUserInfo.addAll(category.getLinkEntityList());
        }
        log.info("Full links list from all categories by username in service: " + categoryEntityListByUserInfo);

        return linkEntityListByUserInfo;
    }

    public List<CategoryEntity> allCategories() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userService.findByUsername(userDetails.getUsername());

        return linkRepository.findMenuByUsername(userInfo.getUsername());
    }


    public void addLink(LinkEntity linkEntity, String category) {
        CategoryEntity categoryEntity = new CategoryEntity();

        for (CategoryEntity savedCategory : linkRepository.categoryList()) {
            if (savedCategory.getName().equals(category)) {
                categoryEntity = savedCategory;
            }
        }
        log.info("Category received by name from repository for adding to linkEntity in service : " + categoryEntity);
        linkEntity.setCategoryEntity(categoryEntity);

        linkRepository.addLink(linkEntity);
        log.info("LinkEntity with added category were sent for saving to repository: " + linkEntity);
    }


    public void addCategory(CategoryEntity categoryEntity) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userService.findByUsername(userDetails.getUsername());

        categoryEntity.setUserInfo(userInfo);

        linkRepository.addCategory(categoryEntity);
        log.info("Category was sent for saving from service to repository: " + categoryEntity);
    }


    public List<LinkEntity> showLinksByCategory(String category) {
        List<LinkEntity> linkEntityList = new LinkedList<>();

        for (CategoryEntity savedLink : linkRepository.categoryList()) {
            if (savedLink.getName().equals(category)) {
                linkEntityList = savedLink.getLinkEntityList();
            }
        }
        log.info("List of the Links received from repository to service and will be returned to controller: " + linkEntityList);
        return linkEntityList;
    }

    public void deleteLink(LinkEntity linkEntity) {

        for (LinkEntity savedLink : linkRepository.linkList()) {
            if (savedLink.getName().equals(linkEntity.getName())) {
                linkRepository.deleteLinkByName(savedLink);
                log.info("LinkEntity was sent from service to repository for deleting: " + savedLink);
            }
        }
    }

    public void deleteCategory(CategoryEntity categoryEntity) {

        for (CategoryEntity savedCategory : linkRepository.categoryList()) {
            if (savedCategory.getName().equals(categoryEntity.getName())) {
                linkRepository.deleteCategoryByName(savedCategory);
                log.info("CategoryEntity was sent from service to repository for deleting: " + savedCategory);
            }
        }
    }

}
