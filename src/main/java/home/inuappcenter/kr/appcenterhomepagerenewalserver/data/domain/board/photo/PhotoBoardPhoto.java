package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.photo;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroductionBoard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PhotoBoardPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PhotoBoardPhoto_id;

    @ManyToOne
    @JoinColumn(name = "photoBoard_id")
    private IntroductionBoard content_id;
}
