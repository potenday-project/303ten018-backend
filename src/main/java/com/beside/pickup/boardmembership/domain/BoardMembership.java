package com.beside.pickup.boardmembership.domain;

import com.beside.pickup.board.domain.Board;
import com.beside.pickup.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardMembership {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private BoardMembershipStatus status;

    @Builder
    public BoardMembership(Board board, Member member, BoardMembershipStatus status) {
        this.board = board;
        this.member = member;
        this.status = status;
    }

    public void setBoard(Board board) {
        if (this.board != null) {
            this.board.getBoardMemberships().remove(this);
        }
        this.board = board;
        board.getBoardMemberships().add(this);
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getBoardMemberships().remove(this);
        }
        this.member = member;
        member.getBoardMemberships().add(this);
    }
}
