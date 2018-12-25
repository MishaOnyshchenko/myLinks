package com.links.dao.repository;

import com.links.dao.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * стандартный JPA репозиторий который работает с объектами.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);

    void deleteById(Long id);
}
