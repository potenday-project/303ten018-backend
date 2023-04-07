package com.beside.pickup.boardmembership;

import com.beside.pickup.board.domain.Board;
import com.beside.pickup.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardMembership {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private BoardMembershipStatus status;

    public void setBoard(Board board) {
        if (this.board != null) {
            this.board.getBoardMemberships().remove(this);
        }
        this.board = board;
        board.getBoardMemberships().add(this);
    }
}
