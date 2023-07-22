package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@NoArgsConstructor
public class ImageRequestDto {
    private List<MultipartFile> multipartFileList;

    public ImageRequestDto(List<MultipartFile> multipartFileList) {
        this.multipartFileList = multipartFileList;
    }
}
