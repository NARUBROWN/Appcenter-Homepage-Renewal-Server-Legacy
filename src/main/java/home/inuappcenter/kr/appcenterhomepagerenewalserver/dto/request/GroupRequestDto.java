package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupRequestDto {
    private String part;
    private Double year;
}
