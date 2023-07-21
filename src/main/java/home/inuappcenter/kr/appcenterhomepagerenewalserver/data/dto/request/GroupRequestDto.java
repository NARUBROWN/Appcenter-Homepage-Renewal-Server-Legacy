package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupRequestDto {
    @NotBlank
    private String part;

    @NotBlank
    @Min(value = 13)
    @Max(value = 20)
    private Double year;
}
