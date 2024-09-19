package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class Quiz08 {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 아이디검색() {
		List<Member> list = memberRepository.get1("user");
		for(Member member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void 등급검색() {
		List<Member> list = memberRepository.get2("관리자");
		for(Member member : list) {
			System.out.println(member);
		}
	}
}
