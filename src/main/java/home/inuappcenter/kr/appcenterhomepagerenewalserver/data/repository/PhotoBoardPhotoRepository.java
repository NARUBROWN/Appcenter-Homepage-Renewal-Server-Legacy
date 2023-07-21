package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.photo.PhotoBoardPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoBoardPhotoRepository extends JpaRepository<PhotoBoardPhoto, Long> {
}
