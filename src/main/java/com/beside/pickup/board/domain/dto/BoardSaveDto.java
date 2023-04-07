package com.beside.pickup.board.domain.dto;

import com.beside.pickup.board.domain.BoardStatus;
import com.beside.pickup.boardmembership.domain.BoardMembershipStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BoardSaveDto {
    private String loginId;
    private String title;
    private LocalDate meetingDate;
    private Long placeId;
    private Long participantsNumber;
    private String contents;
    private BoardMembershipStatus boardMemberStatus;
    private BoardStatus boardStatus;
}
