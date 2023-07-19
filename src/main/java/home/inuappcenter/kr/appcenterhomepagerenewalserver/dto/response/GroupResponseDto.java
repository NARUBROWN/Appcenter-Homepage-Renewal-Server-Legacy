package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Group;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
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

    public void setGroupResponseDto(Long member_id, Long role_id, Group group) {
        this.group_id = group.getGroup_id();
        this.member_id = member_id;
        this.role_id = role_id;
        this.part = group.getPart();
        this.year = group.getYear();
    }
}
