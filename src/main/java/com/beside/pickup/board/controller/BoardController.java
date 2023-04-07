package com.beside.pickup.board.controller;

import com.beside.pickup.board.domain.dto.BoardSaveDto;
import com.beside.pickup.board.domain.dto.BoardStatusDto;
import com.beside.pickup.board.service.BoardService;
import com.beside.pickup.place.domain.dto.PlaceDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시물 저장", description = "게시판 저장 boardMemberStatus : REQUEST(신청), APPROVAL(승인), " +
            "boardStatus : RECRUITING(모집중), CLOSED(모집완료), COMPLETED(진행완료)", tags = {"모임"})
    @PostMapping("")
    public ResponseEntity addBoard(@RequestBody BoardSaveDto boardSaveDto) {
        boardService.save(boardSaveDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "게시물 상태 변경", description = "게시물 자체 상태 변경 " +
            "BoardStatus : RECRUITING(모집중), CLOSED(모집완료), COMPLETED(진행완료)", tags = {"모임"})
    @PostMapping("/board/status")
    public ResponseEntity updateBoardStatus(@RequestBody BoardStatusDto boardStatusDto) {
        boardService.updateStatus(boardStatusDto);
        return new ResponseEntity(HttpStatus.OK);
    }


}
