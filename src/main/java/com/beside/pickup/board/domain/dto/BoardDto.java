package com.beside.pickup.board.domain.dto;

import com.beside.pickup.board.domain.BoardStatus;
import com.beside.pickup.boardmembership.domain.dto.BoardMembershipDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BoardDto {
    private Long boardId;
    private String title;
    private LocalDate meetingDate;
    private Long participantsNumber;
    private String contents;
    private BoardStatus status;

    private Long placeId;
    private String shortAddress;
    private String detailAddress;

    private List<BoardMembershipDto> boardMemberships;
}
