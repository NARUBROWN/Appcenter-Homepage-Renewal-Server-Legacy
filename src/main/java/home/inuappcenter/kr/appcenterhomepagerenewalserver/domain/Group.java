package home.inuappcenter.kr.appcenterhomepagerenewalserver.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "appcenter_group")
public class Group {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "member_id")
    private Member member_id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "role_id")
    private Role role_id;

    @NotNull
    private String part;

    @NotNull
    private Double year;
}
