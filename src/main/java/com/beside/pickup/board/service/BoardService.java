package com.beside.pickup.board.service;

import com.beside.pickup.board.domain.Board;
import com.beside.pickup.board.domain.dto.BoardDto;
import com.beside.pickup.board.domain.dto.BoardSaveDto;
import com.beside.pickup.board.domain.dto.BoardStatusDto;
import com.beside.pickup.board.domain.dto.MyBoardDto;
import com.beside.pickup.board.repository.BoardRepository;
import com.beside.pickup.boardmembership.domain.BoardMembership;
import com.beside.pickup.boardmembership.domain.dto.BoardMembershipDto;
import com.beside.pickup.boardmembership.repository.BoardMembershipRepository;
import com.beside.pickup.member.domain.Member;
import com.beside.pickup.member.repository.MemberRepository;
import com.beside.pickup.place.domain.Place;
import com.beside.pickup.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final PlaceRepository placeRepository;
    private final MemberRepository memberRepository;
    private final BoardMembershipRepository boardMembershipRepository;

    @Transactional
    public void save(BoardSaveDto boardSaveDto) {
        Place place = placeRepository.findById(boardSaveDto.getPlaceId())
                .orElseThrow(() -> new IllegalArgumentException("no such place"));

        Member member = memberRepository.findByLoginId(boardSaveDto.getLoginId());

        Board board = Board.builder()
                .title(boardSaveDto.getTitle())
                .contents(boardSaveDto.getContents())
                .meetingDate(boardSaveDto.getMeetingDate())
                .place(place)
                .participantsNumber(boardSaveDto.getParticipantsNumber())
                .status(boardSaveDto.getBoardStatus())
                .build();

        BoardMembership boardMembership = BoardMembership.builder()
                .member(member)
                .board(board)
                .status(boardSaveDto.getBoardMemberStatus())
                .build();

        board.addBoardMembership(boardMembership);
        member.addBoardMembership(boardMembership);

        boardRepository.save(board);
        boardMembershipRepository.save(boardMembership);

    }

    @Transactional
    public void updateStatus(BoardStatusDto boardStatusDto) {
        Board board = boardRepository.findById(boardStatusDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("no such board"));

        board.changeStatus(boardStatusDto.getBoardStatus());
    }

    public List<BoardDto> getBoardList() {
        return boardRepository.findAll().stream().map(Board::BoardToBoardDto).collect(Collectors.toList());

    }

    public BoardDto getBoard(Long boardId) {
        Board board = boardRepository.findFetchById(boardId);

        return Board.BoardToBoardDto(board);
    }

    public List<MyBoardDto> getMyBoard(String username) {
        List<Board> myBoardList = boardRepository.findByBoardMembershipMemberId(username);

        return myBoardList.stream().map(Board::BoardToMyBoardDto).collect(Collectors.toList());
    }
}
