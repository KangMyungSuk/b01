package org.zerok.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.zerok.b01.domain.Board;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    // 테이블 자동 삽입, 생성도 진행됨. 없어니 지가 그냥 만듬.
    // insert/update 자동 save 기능
    @Test
    public void testInsert() {

        IntStream.rangeClosed(1, 100).forEach(i ->{
            Board board = Board.builder()
                    .title("title....." +i)
                    .content("content..." + i)
                    .writer("user" + (i%10))
                    .build();

            Board result = boardRepository.save(board);
            log.info("BNO: " + result.getBno());
        });
    }

    //게시물 조회 기능 findByID()

    @Test
    public void testSelect(){

        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        log.info(board);
    }

    // update 테스트 코드 ( Entity에 변경 가능한 것을 change라고 미리 준비

    @Test
    public void testUpdate() {

        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        board.change("update.. title 100", "update content 100");

        boardRepository.save(board);

    }

    // delete 진행(deleteById()

    @Test
    public void testDelete() {

        Long bno = 1L;

        boardRepository.deleteById(bno);

    }

    // 페이징 처리 TEST

    @Test
    public void testPaging() {

        // 1 page order by bno desc
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);

        log.info("Total count: " + result.getTotalElements());
        log.info("total pages: " + result.getTotalPages());
        log.info("page number: " + result.getNumber());
        log.info("page size: " + result.getSize());

        List<Board> todoList = result.getContent();

        todoList.forEach(board -> log.info(board));



    }


}
