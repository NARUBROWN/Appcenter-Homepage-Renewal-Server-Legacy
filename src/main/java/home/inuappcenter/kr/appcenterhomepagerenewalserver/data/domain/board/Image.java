package home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.ImageRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.utils.ImageUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "introduction_board_id")
    private IntroBoard introductionBoard;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "image_data", columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;

    @Column(name = "file_size")
    private Long fileSize;

    public Image(String originalFileName, byte[] imageData, Long fileSize, IntroBoard introBoard) {
        this.originalFileName = originalFileName;
        this.imageData = ImageUtils.compressImage(imageData);
        this.fileSize = fileSize;
        this.introductionBoard = introBoard;
    }

    public List<Image> toList(ImageRequestDto imageRequestDto, IntroBoard introBoard) throws IOException {
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile file: imageRequestDto.getMultipartFileList()) {
            Image image = new Image(file.getOriginalFilename(), file.getBytes(), file.getSize(), introBoard);
            imageList.add(image);
        }
        return imageList;
    }


}
