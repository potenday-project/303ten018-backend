package com.beside.pickup.board.domain;

import com.beside.pickup.boardmembership.BoardMembership;
import com.beside.pickup.place.Place;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private LocalDate meetingDate;
    private Long participantsNumber;
    private String contents;
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
}
