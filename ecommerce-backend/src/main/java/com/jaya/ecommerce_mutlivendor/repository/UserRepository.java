package com.jaya.ecommerce_mutlivendor.repository;


import com.jaya.ecommerce_mutlivendor.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
