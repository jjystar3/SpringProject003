package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class Quiz07 {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 주소검색() {
		List<Order> list = orderRepository.get1("인천");
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 주문일검색() {
		List<Order> list = orderRepository.get2(7,3);
		for(Order order : list) {
			System.out.println(order);
		}
	}
}
