package com.beside.pickup.boardmembership.domain.dto;

import com.beside.pickup.boardmembership.domain.BoardMembership;
import com.beside.pickup.boardmembership.domain.BoardMembershipStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardMembershipDto {
    private Long memberId;
    private Long boardId;
    private BoardMembershipStatus boardMemberStatus;

}
