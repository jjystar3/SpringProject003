package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class Quiz03 {

	@Autowired
	OrderRepository orderRepository;

	@Test
	public void 데이터단건조회() {
		Optional<Order> result = orderRepository.findById(1); 
		
		if (result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}	
	
	@Test
	public void 데이터전체조회() {
		List<Order> list = orderRepository.findAll(); //조회결과를 리스트로 반환
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터추가() {

		List<Order> list = new ArrayList<>();
		
		LocalDate localdate1 = LocalDate.of(2023, 7, 1);
		LocalDate localdate2 = LocalDate.of(2023, 7, 2);
		LocalDate localdate3 = LocalDate.of(2023, 7, 3);

		Order order1 = Order.builder()
				.customer_name("둘리")
				.order_date(localdate1)
				.ship_address("인천 구월동")
				.build();

		Order order2 = Order.builder()
				.customer_name("또치")
				.order_date(localdate2)
				.ship_address("인천 연수동")
				.build();

		Order order3 = Order.builder()
				.customer_name("도우너")
				.order_date(localdate3)
				.ship_address("부산 동래동")
				.build();

		Order order4 = Order.builder()
				.customer_name("마이콜")
				.order_date(localdate1)
				.build();

		Order order5 = Order.builder()
				.customer_name("고길동")
				.order_date(localdate2)
				.build();

		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);

		orderRepository.saveAll(list);
	}

	@Test
	public void 데이터수정() {
		Optional<Order> result = orderRepository.findById(1);
		Order order = result.get();
		order.setCustomer_name("홍길동");
		
		orderRepository.save(order);
	}	
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		orderRepository.deleteAll();
	}
}
