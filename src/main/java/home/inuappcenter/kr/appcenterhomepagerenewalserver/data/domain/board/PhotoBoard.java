package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PhotoBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoBoard_id;

    private String body;
}
