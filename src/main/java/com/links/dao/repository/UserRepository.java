package com.bookmark.service.dao.repository;

import com.bookmark.service.dao.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * стандартный JPA репозиторий который работает с объектами.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
