package org.zerok.b01.repository.search;

import org.springframework.data.domain.Page;
import org.zerok.b01.domain.Board;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> search1(Pageable pageable);


}
