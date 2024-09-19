package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	@Query(value = "select * from tbl_member where user_id like CONCAT(:param,'%')", nativeQuery = true)
	List<Member> get1(@Param("param") String userId);
	
	@Query(value = "select * from tbl_member where grade = :param", nativeQuery = true)
	List<Member> get2(@Param("param") String userId);
}
