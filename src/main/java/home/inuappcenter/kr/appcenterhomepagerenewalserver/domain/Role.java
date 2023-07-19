package home.inuappcenter.kr.appcenterhomepagerenewalserver.domain;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.RoleRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Role {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @NotNull
    private String role_name;

    public void setRole(RoleRequestDto roleRequestDto) {
        this.role_name = roleRequestDto.getRole_name();
    }
}
