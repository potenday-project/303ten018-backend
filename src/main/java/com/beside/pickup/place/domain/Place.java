package com.beside.pickup.place.domain;

import com.beside.pickup.board.domain.Board;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place {

    @Id @GeneratedValue
    private Long id;
    private String shortAddress;
    private String detailAddress;

    @OneToMany(mappedBy = "place")
    private List<Board> boards = new ArrayList<>();

    public void addBoard(Board board) {
        this.boards.add(board);
        if (board.getPlace() != this) {
            board.setPlace(this);
        }
    }
}
