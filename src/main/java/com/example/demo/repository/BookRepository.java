package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // 1.SQL을 그대로 작성한다
	// 2.변경될 수 있는 값(파라미터)을 매개변수로 선언한다
	// 예를 들어 제목은 '자바~' 또는 '스프링~' 또는 '빈문자열'가 될 수 있다.
	// 이런값들은 외부에서 입력받아 SQL에 동적으로 적용될 수 있도록 처리한다
	// 3.파라미터로 전달된 값을 SQL에 바인딩한다
	
	@Query(value = "select * from tbl_book where title = :param", nativeQuery = true)
	List<Book> get1(@Param("param") String book);

	@Query(value = "select * from tbl_book where price >= :param1 and publisher = :param2", nativeQuery = true)
	List<Book> get2(@Param("param1") int price, @Param("param2") String publisher);
	
	@Query(value = "select * from tbl_book where publisher in :param", nativeQuery = true)
	List<Book> get3(@Param("param") List<String> publishers);
	
}
