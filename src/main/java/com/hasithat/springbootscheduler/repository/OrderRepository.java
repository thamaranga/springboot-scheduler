package com.hasithat.springbootscheduler.repository;

import com.hasithat.springbootscheduler.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
