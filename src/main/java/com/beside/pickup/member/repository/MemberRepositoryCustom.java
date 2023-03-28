package com.beside.pickup.member.repository;

import com.beside.pickup.member.domain.Member;

public interface MemberRepositoryCustom {
    Member findByLoginId(String loginId);
}
