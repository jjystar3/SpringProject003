package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class Quiz06 {

	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 가격검색() {
		List<Gift> list = giftRepository.get1(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}

	@Test
	public void 선물검색() {
		List<Gift> list = giftRepository.get2("세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 검색() {
		List<Gift> list = giftRepository.get3(40000, "생활용품");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
}
