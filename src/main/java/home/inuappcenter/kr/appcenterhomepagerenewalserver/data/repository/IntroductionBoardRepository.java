package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroductionBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroductionBoardRepository extends JpaRepository<IntroductionBoard, Long> {
}
