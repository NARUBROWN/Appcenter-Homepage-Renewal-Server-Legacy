package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private String description;
    private String profileImage;
    private String blogLink;
    private String email;
    private String gitRepositoryLink;
}
