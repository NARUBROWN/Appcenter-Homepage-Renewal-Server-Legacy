package home.inuappcenter.kr.appcenterhomepagerenewalserver.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
