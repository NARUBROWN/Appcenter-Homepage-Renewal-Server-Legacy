package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupRequestDto {
    private Long member_id;
    private Long role_id;
    private String part;
    private Double year;
}
