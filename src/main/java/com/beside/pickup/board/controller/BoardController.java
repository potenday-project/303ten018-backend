package com.beside.pickup.board.controller;

import com.beside.pickup.board.domain.dto.BoardSaveDto;
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

    @Operation(summary = "게시판 저장", description = "게시판 저장", tags = {"모임"})
    @PostMapping("")
    public ResponseEntity addBoard(@RequestBody BoardSaveDto boardSaveDto) {
        boardService.save(boardSaveDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
