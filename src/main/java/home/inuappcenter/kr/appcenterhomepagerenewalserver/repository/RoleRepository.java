package home.inuappcenter.kr.appcenterhomepagerenewalserver.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
