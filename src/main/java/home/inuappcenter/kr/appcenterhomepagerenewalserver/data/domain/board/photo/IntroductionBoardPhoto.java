package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.photo;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroductionBoard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class IntroductionBoardPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IntroductionBoardPhoto_id;

    @ManyToOne
    @JoinColumn(name = "introduction_board_id")
    private IntroductionBoard content_id;
}
