package com.beside.pickup.board.repository;

import com.beside.pickup.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardCustomRepository {
    Board findFetchById(Long boardId);

    List<Board> findByBoardMembershipMemberId(String memberId);
}
