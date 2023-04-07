package com.beside.pickup.boardmembership.domain.dto;

import com.beside.pickup.boardmembership.domain.BoardMembership;
import com.beside.pickup.boardmembership.domain.BoardMembershipStatus;
import lombok.Data;

@Data
public class BoardMembershipDto {
    private Long memberId;
    private Long boardId;
    private BoardMembershipStatus boardMemberStatus;

}
