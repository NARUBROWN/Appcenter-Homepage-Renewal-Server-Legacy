package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.GroupRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.GroupResponseDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "appcenter_group")
public class Group {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "role_id")
    private Role role;

    @NotNull
    private String part;

    @NotNull
    private Double year;

    public void setGroup(Member member, Role role, GroupRequestDto groupRequestDto) {
        this.member = member;
        this.role = role;
        this.part = groupRequestDto.getPart();
        this.year = groupRequestDto.getYear();
    }

    public GroupResponseDto toGroupResponseDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setGroupResponseDto(group);
        return groupResponseDto;
    }
}
