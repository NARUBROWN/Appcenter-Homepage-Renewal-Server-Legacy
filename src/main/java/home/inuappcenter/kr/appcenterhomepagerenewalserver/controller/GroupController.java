package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.GroupRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.GroupResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @Operation(summary = "그룹 멤버 (1명) 조회", description = "조회할 group_id을 입력해주세요")
    @GetMapping
    public ResponseEntity<GroupResponseDto> getGroup(Long id) throws Exception {
        GroupResponseDto groupResponseDto = groupService.getGroup(id);
        return ResponseEntity.status(HttpStatus.OK).body(groupResponseDto);
    }

    @Operation(summary = "그룹 멤버 (전체) 조회", description = "전체 그룹 멤버를 반환합니다.")
    @GetMapping("/all-groups-members")
    public ResponseEntity<List<GroupResponseDto>> findAllGroup() {
        List<GroupResponseDto> dto_list = groupService.findAllGroup();
        return ResponseEntity.status(HttpStatus.OK).body(dto_list);
    }

    // 등록 시 String 멤버 이름, String 파트 이름을 받도록 하는게 편할 것 같음
    // 예상되는 문제: 중복처리
    @Operation(summary = "그룹 멤버 (1명) 편성", description = "저장할 member_id(멤버)와 role_id(역할)을 입력해주세요")
    @PostMapping
    public ResponseEntity<GroupResponseDto> assignGroup(@RequestBody GroupRequestDto groupRequestDto, Long member_id, Long role_id) throws Exception {
            GroupResponseDto groupResponseDto = groupService.assignGroup(member_id, role_id, groupRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(groupResponseDto);
    }

    // 파트 / 기수별로 조회해주는 API 필요
    // 서버 파트 + 14기.. 는 {..., ..., ...}

    // 삭제 API 필요
    // 그룹 삭제 후 멤버 삭제가 이뤄져야 하기 때문에 신경써서 로직 구현해야됨
    @Operation(summary = "그룹 멤버 (1명) 삭제", description = "삭제할 Group id를 입력해주세요")
    @DeleteMapping
    public ResponseEntity<String> deleteGroup(Long id) {
        String result = groupService.deleteGroup(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
