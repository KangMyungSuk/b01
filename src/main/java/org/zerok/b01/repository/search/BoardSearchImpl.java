package org.zerok.b01.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerok.b01.domain.Board;
import org.springframework.data.domain.Pageable;
import org.zerok.b01.domain.QBoard;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{


    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {

        QBoard board = QBoard.board; //Q도메인 객체

        JPQLQuery<Board> query = from(board); // select .. from board

        query.where(board.title.contains("1")); // where title like

        return null;
    }
}
