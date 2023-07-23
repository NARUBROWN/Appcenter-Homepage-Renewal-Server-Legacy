package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.Group;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByIsThumbnailTrue();
}
