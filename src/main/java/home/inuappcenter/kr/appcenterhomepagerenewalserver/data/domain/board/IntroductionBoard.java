package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "introduction_board")
public class IntroductionBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long introduction_board_id;

    private String body;

}
