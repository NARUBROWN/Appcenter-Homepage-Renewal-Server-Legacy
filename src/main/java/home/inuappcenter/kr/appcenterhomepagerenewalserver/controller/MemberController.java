package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.MemberRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.MemberResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "동아리원 (1명) 정보 가져오기", description = "동아리원에게 부여된 id를 입력해주세요 / 동아리원(1명)을 반환합니다.")
    @Parameter(name = "id", description = "동아리원 id", required = true)
    @GetMapping
    public ResponseEntity<MemberResponseDto> getMember(Long id) throws Exception {
        MemberResponseDto memberResponseDto = memberService.getMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(memberResponseDto);
    }

    @Operation(summary = "동아리원 (1명) 등록하기", description = "등록할 동아리원 정보를 입력해주세요")
    @Parameter(name = "memberRequestDto", description = "동아리원 정보", required = true)
    @PutMapping
    public ResponseEntity<MemberResponseDto> saveMember(@RequestBody MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = memberService.saveMember(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseDto);
    }

}