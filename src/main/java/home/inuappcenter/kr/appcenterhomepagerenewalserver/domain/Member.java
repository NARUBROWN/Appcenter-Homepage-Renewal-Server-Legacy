package home.inuappcenter.kr.appcenterhomepagerenewalserver.domain;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.dto.request.MemberRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String name;

    private String description;

    public void setMember(MemberRequestDto memberRequestDto) {
        this.name = memberRequestDto.getName();
        this.description = memberRequestDto.getDescription();
    }
}
