package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long member_id;
    private String name;
    private String description;

    public void setMemberResponseDto(Member member) {
        this.member_id = member.getMember_id();
        this.name = member.getName();
        this.description = member.getDescription();
    }
}
