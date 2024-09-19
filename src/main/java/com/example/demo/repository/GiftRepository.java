package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer> {

	@Query(value = "select * from tbl_gift where price >= :param", nativeQuery = true)
	List<Gift> get1(@Param("param") int price);

	@Query(value = "select * from tbl_gift where name like CONCAT('%',:param)", nativeQuery = true)
	List<Gift> get2(@Param("param") String name);

	@Query(value = "select * from tbl_gift where price <= :param1 and type = :param2", nativeQuery = true)
	List<Gift> get3(@Param("param1") int price,@Param("param2") String type);
}
