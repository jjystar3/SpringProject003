package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 엔티티: 데이터베이스의 테이블 구조를 정의하는 클래스

@Entity // 엔티티 클래스 표시 (필수)
//@Table(name = "tbl_memo") // 테이블 이름
public class Memo {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	int no;
	
	// 일반컬럼
	// 컬럼의 크기와 제약사항
	@Column(length = 200, nullable = true)
	String text;
	
}
