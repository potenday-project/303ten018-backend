package com.beside.pickup.board.repository;

import com.beside.pickup.board.domain.Board;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.beside.pickup.board.domain.QBoard.board;
import static com.beside.pickup.boardmembership.domain.QBoardMembership.boardMembership;
import static com.beside.pickup.place.domain.QPlace.place;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Board findFetchById(Long boardId) {
        return jpaQueryFactory.selectFrom(board)
                .join(board.place, place)
                .join(board.boardMemberships, boardMembership).fetchJoin()
                .where(board.id.eq(boardId)).fetchOne();

    }

    @Override
    public List<Board> findByBoardMembershipMemberId(String memberId) {
        return jpaQueryFactory.selectFrom(board)
                .join(board.place, place)
                .join(board.boardMemberships, boardMembership).fetchJoin()
                .where(boardMembership.member.loginId.eq(memberId)).fetch();
    }

}
