package com.beside.pickup.board.domain.dto;

import com.beside.pickup.board.domain.BoardStatus;
import lombok.Data;

@Data
public class BoardStatusDto {
    private Long boardId;
    private BoardStatus boardStatus;
}
