package com.baluchi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluchi.ecommerce.ecommerce.entity.User;
import com.baluchi.ecommerce.ecommerce.enums.UserRole;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole userRole);

}
