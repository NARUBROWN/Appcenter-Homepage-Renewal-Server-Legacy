package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class IntroBoardResponseDto {
    private Long introBoard_id;
    private String body;
    private List<Long> images;

    public void setIntroBoardResponse(IntroBoard introBoard, List<Long> ids) {
        this.introBoard_id = introBoard.getIntroduction_board_id();
        this.body = introBoard.getBody();
        this.images = ids;
    }
}
