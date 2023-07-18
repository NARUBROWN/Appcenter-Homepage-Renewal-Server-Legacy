package home.inuappcenter.kr.appcenterhomepagerenewalserver.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
