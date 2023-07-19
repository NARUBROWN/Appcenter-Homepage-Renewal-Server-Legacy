package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.RoleRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.RoleResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @Operation(summary = "역할 (1개) 가져오기", description = "역할에게 부여된 id를 입력해주세요 / 역할 1개를 반환합니다.")
    @Parameter(name = "id", description = "역할 id", required = true)
    @GetMapping
    public ResponseEntity<RoleResponseDto> getRole(Long id) throws Exception {
        RoleResponseDto roleResponseDto = roleService.getRole(id);
        return ResponseEntity.status(HttpStatus.OK).body(roleResponseDto);
    }

    @Operation(summary = "역할 저장", description = "저장할 역할 정보를 입력해주세요 / 역할 1개를 저장합니다.")
    @PutMapping
    public ResponseEntity<RoleResponseDto> saveRole(@RequestBody RoleRequestDto roleRequestDto) {
        RoleResponseDto roleResponseDto = roleService.saveRole(roleRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleResponseDto);
    }
}
