package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.MemberRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.MemberResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @NotNull
    private String name;

    private String description;

    public void setMember(MemberRequestDto memberRequestDto) {
        this.name = memberRequestDto.getName();
        this.description = memberRequestDto.getDescription();
    }

    public void setMember(Long id, MemberRequestDto memberRequestDto) {
        this.member_id = id;
        this.name = memberRequestDto.getName();
        this.description = memberRequestDto.getDescription();
    }

    public MemberResponseDto toMemberResponseDto(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setMemberResponseDto(member);
        return memberResponseDto;
    }
}
