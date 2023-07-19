package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupResponseDto {
    private Long group_id;
    private String member_id;
    private String role_id;
    private String part;
    private Double year;

    public void setGroupResponseDto(Group group) {
        this.group_id = group.getGroup_id();
        this.member_id = group.getMember_id().getName();
        this.role_id = group.getRole_id().getRole_name();
        this.part = group.getPart();
        this.year = group.getYear();
    }
}
