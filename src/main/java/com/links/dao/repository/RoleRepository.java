package com.bookmark.service.dao.repository;


import com.bookmark.service.dao.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
