package com.beside.pickup.board.domain.dto;

import com.beside.pickup.board.domain.BoardStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MyBoardDto {
    private Long boardId;
    private String title;
    private LocalDate meetingDate;
    private Long participantsNumber;
    private String contents;
    private BoardStatus status;

    private Long placeId;
    private String shortAddress;
    private String detailAddress;
}
