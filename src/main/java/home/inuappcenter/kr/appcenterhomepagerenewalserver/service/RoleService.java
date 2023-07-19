package home.inuappcenter.kr.appcenterhomepagerenewalserver.service;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.RoleRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.RoleResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleResponseDto getRole(Long id) throws Exception {
        Role getRole = roleRepository.findById(id).orElseThrow(Exception::new);
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setRoleResponseDto(getRole);
        return roleResponseDto;
    }

    public RoleResponseDto saveRole(RoleRequestDto roleRequestDto) {
        Role role = new Role();
        role.setRole(roleRequestDto);
        Role savedRole = roleRepository.save(role);
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setRoleResponseDto(savedRole);
        return roleResponseDto;
    }
}
