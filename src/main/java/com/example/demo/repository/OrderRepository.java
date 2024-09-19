package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value = "select * from tbl_order where ship_address like CONCAT('%',:param,'%')", nativeQuery = true)
	List<Order> get1(@Param("param") String address);

	@Query(value = "select * from tbl_order where month(order_date) = :param1 and day(order_date) = :param2", nativeQuery = true)
	List<Order> get2(@Param("param1") int month, @Param("param2") int date);
}
