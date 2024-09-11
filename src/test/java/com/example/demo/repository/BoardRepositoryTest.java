package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		// 1. 스프링이 BoardRepository의 구현체 만들고 
		// 2. 객체(빈)을 생성해서 컨테이너에 담음 (얘는 @Component없어도 됨)
		// 3. @Autowired를 보고 변수에 객체를 넣어줌
		System.out.println("boardRepository = " + boardRepository);
	}
	

	@Test
	public void 데이터등록() {

		Board board1 = Board.builder()
								.title("2번글")
								.content("내용입니다")
								.build();
		
		boardRepository.save(board1);
	}
	
	@Test
	public void 데이터단건조회() {
		
		// 조회결과를 optional로 반환
		Optional<Board> result = boardRepository.findById(1); 
		
		// 값이 있는지 확인하고 꺼내기
		if (result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}

	@Test
	public void 데이터전체조회() {
		// findAll: 테이블에 있는 모든 데이터를 조회하는 함수
		List<Board> list = boardRepository.findAll(); 
		
		// 람다식 포문으로 하나씩 출력
		for (Board board : list) {
			System.out.println(board);
		}
	}

	@Test
	public void 데이터수정() {
		
		// 옳은 수정 방법
		// 게시물 조회하고 값을 일부 변경한 후에 수정하기
		Optional<Board> result = boardRepository.findById(2);
		Board board = result.get();
		board.setContent("내용이수정되었습니다~");
		
		// 1번 게시물이 이미 존재하기 때문에 update가 실행됨
		// 수정일만 자동으로 현재시간이 입력됨 
		boardRepository.save(board);
		
		// 잘못된 수정 방법
		// 게시물을 생성해서 수정하기 
		//Board board1 = new Board(1, "1번글", "글이수정되었습니다", null, null);
		//boardRepository.save(board1);
	}	

	@Test
	public void 데이터삭제() {
		boardRepository.deleteById(1); // 1번이 존재하는지 확인하고 delete 실행
	}

	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll(); // 테이블을 조회하고 모든 데이터를 삭제함
	}

}
