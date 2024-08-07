package com.magret.repo;

import com.magret.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepo extends JpaRepository<OrderLine , Integer> {

    List<OrderLine> findAllByOrderId(Integer orderId);

}
