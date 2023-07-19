package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.GroupRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.GroupResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @Operation(summary = "멤버 (1명) 조회", description = "조회할 group_id을 입력해주세요")
    @GetMapping
    public ResponseEntity<GroupResponseDto<String>> getGroup(Long id) throws Exception {
        GroupResponseDto<String> groupResponseDto = groupService.getGroup(id);
        return ResponseEntity.status(HttpStatus.OK).body(groupResponseDto);
    }

    @Operation(summary = "멤버 (1명) 편성", description = "저장할 member_id(멤버)와 role_id(역할)을 입력해주세요")
    @PutMapping
    public ResponseEntity<GroupResponseDto<Long>> saveGroup(@RequestBody GroupRequestDto groupRequestDto, Long member_id, Long role_id) throws Exception {
            GroupResponseDto<Long> groupResponseDto = groupService.saveGroup(member_id, role_id, groupRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(groupResponseDto);
    }
}
