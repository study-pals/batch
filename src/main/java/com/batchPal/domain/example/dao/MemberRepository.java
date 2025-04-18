package com.batchPal.domain.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batchPal.domain.example.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {}
