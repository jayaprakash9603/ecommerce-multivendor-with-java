package com.jaya.ecommerce_mutlivendor.repository;

import com.jaya.ecommerce_mutlivendor.modal.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
