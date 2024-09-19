package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class Quiz05 {

	@Autowired
	BookRepository bookRepository;

	@Test
	public void 책검색() {
		List<Book> list = bookRepository.get1("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 책검색2() {
		List<Book> list = bookRepository.get2(30000, "남가람북스");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test	
	public void 책검색3() {
		List<String> publishers = new ArrayList<>();
		publishers.add("한빛출판사");
		publishers.add("이지스퍼블리싱");
		List<Book> list = bookRepository.get3(publishers);
		for(Book book : list) {
			System.out.println(book);
		}
	}
}
