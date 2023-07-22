package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "photo_board")
public class PhotoBoard extends Board{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photo_board_id;

    private String body;

    @OneToMany(mappedBy = "photoBoard")
    private List<Image> Images = new ArrayList<>();

    public void setPhotoBoard(BoardRequestDto boardRequestDto) {
        this.body = boardRequestDto.getBoard();
    }
}
