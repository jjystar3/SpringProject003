package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoRepositoryTest1_1 {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	void test1() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	public void test2() {
		// save: 테이블에 데이터를 추가하는 함수
		memoRepository.save(null);
	}

}
