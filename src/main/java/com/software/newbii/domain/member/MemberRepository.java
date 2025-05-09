package com.software.newbii.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findById(Long id);

  Optional<Member> findByEmail(String email);
  boolean existsByEmail(String email);
}
