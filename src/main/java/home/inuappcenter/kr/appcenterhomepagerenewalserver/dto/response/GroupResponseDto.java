package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Group;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupResponseDto<T> {
    private Long group_id;
    private T member_id;
    private T role_id;
    private String part;
    private Double year;

    public void setGroupResponseDto(T member_id, T role_id, Group group) {
        this.group_id = group.getGroup_id();
        this.member_id = member_id;
        this.role_id = role_id;
        this.part = group.getPart();
        this.year = group.getYear();
    }

    public void setGroupResponseDto(Group group) {
        this.group_id = group.getGroup_id();
        this.member_id = (T)group.getMember_id().getName();
        this.role_id = (T) group.getRole_id().getRole_name();
        this.part = group.getPart();
        this.year = group.getYear();
    }
}
