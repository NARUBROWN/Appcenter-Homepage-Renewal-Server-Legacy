package home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long member_id;
    private String name;
    private String description;

    public MemberResponseDto setMemberResponseDto(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.member_id = member.getMember_id();
        memberResponseDto.name = member.getName();
        memberResponseDto.description = member.getDescription();

        return memberResponseDto;
    }
}
