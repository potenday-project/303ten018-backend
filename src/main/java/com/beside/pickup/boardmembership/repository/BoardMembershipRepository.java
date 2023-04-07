package com.beside.pickup.boardmembership.repository;

import com.beside.pickup.boardmembership.domain.BoardMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardMembershipRepository extends JpaRepository<BoardMembership, Long> {
}
