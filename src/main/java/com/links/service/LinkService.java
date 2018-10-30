package com.links.service;

import com.links.dao.entity.LinkEntity;
import com.links.dao.repository.LinkRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    List<LinkEntity> linkEntityList = new ArrayList<>();


    public ArrayList<String> allLinks() {
        ArrayList<String> bookmarks = new ArrayList<>();

        linkEntityList = linkRepository.linkList();
        System.out.println("***LinkList*** = " + linkEntityList.toString());

        for (LinkEntity e : linkEntityList) {
            bookmarks.add(e.getName());
        }
        return bookmarks;
    }


    public List<LinkEntity> linkEntityList() {
        return linkEntityList;
    }


    public String addLink(LinkEntity linkEntity) {

        return linkRepository.addLink(linkEntity);
    }


    public void deleteLink() {

    }


}
