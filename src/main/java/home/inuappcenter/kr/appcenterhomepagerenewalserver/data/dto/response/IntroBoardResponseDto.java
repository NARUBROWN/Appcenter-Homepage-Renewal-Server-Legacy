package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IntroBoardResponseDto<T> {
    private Long introBoard_id;
    private String body;
    private T images;

    public void setIntroBoardResponse(IntroBoard introBoard, T images) {
        this.introBoard_id = introBoard.getIntroduction_board_id();
        this.body = introBoard.getBody();
        this.images = images;
    }
}
