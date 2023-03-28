package com.beside.pickup.member.repository;

import com.beside.pickup.member.domain.Member;
import com.beside.pickup.member.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.beside.pickup.member.domain.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findByLoginId(String loginId) {
        return jpaQueryFactory.selectFrom(member)
                .where(member.loginId.eq(loginId))
                .fetchOne();
    }
}
