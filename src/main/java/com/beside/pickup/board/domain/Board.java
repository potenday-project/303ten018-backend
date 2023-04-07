package com.beside.pickup.board.domain;

import com.beside.pickup.boardmembership.domain.BoardMembership;
import com.beside.pickup.common.BaseTimeEntity;
import com.beside.pickup.place.domain.Place;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private LocalDate meetingDate;
    private Long participantsNumber;
    private String contents;
    @Enumerated(EnumType.STRING)
    private BoardStatus status;

    @ManyToOne
    @JoinColumn(name="place_id")
    private Place place;

    @OneToMany(mappedBy = "board")
    private List<BoardMembership> boardMemberships = new ArrayList<>();

    public void setPlace(Place place) {
        if (this.place != null) {
            this.place.getBoards().remove(this);
        }
        this.place = place;
        place.getBoards().add(this);
    }

    public void addBoardMembership(BoardMembership boardMembership) {
        this.boardMemberships.add(boardMembership);
        if (boardMembership.getBoard() != this) {
            boardMembership.setBoard(this);
        }
    }

    @Builder
    public Board(String title, LocalDate meetingDate, Long participantsNumber, String contents, BoardStatus status, Place place) {
        this.title = title;
        this.meetingDate = meetingDate;
        this.participantsNumber = participantsNumber;
        this.contents = contents;
        this.status = status;
        this.place = place;
    }
}
