package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_1 {
	
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	void 리파지토리객체를가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	void 데이터등록() {
		// 새로운 데이터 생성
		Memo memo = Memo.builder().text("새글입니다").build();
		
		// save: 테이블에 데이터를 추가 또는 수정 하는 함수
		// insert: 또는 update sql이 생성됨
		memoRepository.save(memo);
	}

	@Test
	void 데이터일괄등록() {
		// 메모 리스트 생성
		List<Memo> list = new ArrayList<>();
		Memo memo1 = Memo.builder().text("새글입니다").build();
		Memo memo2 = Memo.builder().build();
		list.add(memo1);
		list.add(memo2);
		memoRepository.saveAll(list);
	}
	
	@Test
	void 데이터단건조회() {
		// 결과값을 반환받을 때는 함수의 선언부를 확인 할 것
		// 그리고 그 타입을 대입연산자 앞부분에 변수로 선언
		Optional<Memo> optional = memoRepository.findById(5); //조회결과를 optional로 반환. 결과가 존재하는지 확인하는 형태
		// optional 객체 안에 값이 있는지 확인
//		if(optional.isPresent()) {
//			System.out.println(optional.get());
//		}else {
//			System.out.println("값이 없습니다");
//		}
		System.out.println(optional.isPresent()?optional.get():"값이 없습니다");
		
		// find 함수를 사용하여 select sql이 생성됨
	}

	@Test
	void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll(); //조회결과를 리스트로 반환
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}

	@Test
	void 데이터수정() {
		Memo memo = Memo.builder().no(1).text("글이 수정되었습니다").build();
		memoRepository.save(memo);	//1번이 존재하는지 확인하고 update 실행
		// select > update sql이 생성됨
		// 조회결과에 따라 insert 또는 update가 수행됨
	}
	
	@Test
	void 데이터삭제() {
		//1번이 존재하는지 확인하고 delete 실행
		memoRepository.deleteById(1);
		//1번이 없으면 DataAccessException 에러가 발생함
		// delete 함수를 실행하면 delete sql이 생성됨
	}
	
	@Test
	void 데이터전체삭제() {
		// deleteAll: 테이블을 조회하고 모든 데이터를 삭제함
		memoRepository.deleteAll();
		
		// select를 한 후, 데이터개수 만큼 delete sql이 생성됨
	}
}
