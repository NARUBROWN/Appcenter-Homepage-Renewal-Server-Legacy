package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupResponseDto {
    private Long group_id;
    private Long member_id;
    private Long role_id;
    private String part;
    private Double year;
}
