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

    public MemberResponseDto getMember(Long id) throws Exception {
        Member member = memberRepository.findById(id)
                .orElseThrow(Exception::new);
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setMemberResponseDto(member);
        return memberResponseDto;
    }

    public MemberResponseDto saveMember(MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setMember(memberRequestDto);
        Member saved_member = memberRepository.save(member);
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setMemberResponseDto(saved_member);
        return memberResponseDto;
    }
}
