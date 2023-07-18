package home.inuappcenter.kr.appcenterhomepagerenewalserver.service;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.MemberRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.MemberResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponseDto saveMember(MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setMember(memberRequestDto);
        Member saved_member = memberRepository.save(member);
        return new MemberResponseDto().setMemberResponseDto(saved_member);
    }
}
