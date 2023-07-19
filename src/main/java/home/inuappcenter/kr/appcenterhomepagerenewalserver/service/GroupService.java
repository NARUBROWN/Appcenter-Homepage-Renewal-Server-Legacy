package home.inuappcenter.kr.appcenterhomepagerenewalserver.service;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Group;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Member;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.domain.Role;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.GroupRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.response.GroupResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.repository.GroupRepository;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.repository.MemberRepository;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    public GroupResponseDto<String> getGroup(Long id) throws Exception {
        Group found_group = groupRepository.findById(id).orElseThrow(Exception::new);
        GroupResponseDto<String> groupResponseDto = new GroupResponseDto<>();
        groupResponseDto.setGroupResponseDto(found_group);
        return groupResponseDto;
    }

    public GroupResponseDto<Long> saveGroup(Long member_id, Long role_id, GroupRequestDto groupRequestDto) throws Exception {
        Member found_member = memberRepository.findById(member_id).orElseThrow(Exception::new);
        Role found_role = roleRepository.findById(role_id).orElseThrow(Exception::new);

        Group group = new Group();
        group.setGroup(found_member, found_role, groupRequestDto);
        Group saved_group = groupRepository.save(group);

        GroupResponseDto<Long> groupResponseDto = new GroupResponseDto<>();
        groupResponseDto.setGroupResponseDto(member_id, role_id, saved_group);
        return groupResponseDto;
    }
}
