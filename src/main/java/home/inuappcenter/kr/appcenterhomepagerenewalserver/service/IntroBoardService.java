package home.inuappcenter.kr.appcenterhomepagerenewalserver.service;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.Image;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroBoard;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.ImageRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.IntroBoardRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.IntroBoardResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository.ImageRepository;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository.IntroBoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IntroBoardService {
    private final IntroBoardRepository introBoardRepository;
    private final ImageRepository imageRepository;

    // 게시글 저장하기
    public IntroBoardResponseDto saveBoard(IntroBoardRequestDto introBoardRequestDto, ImageRequestDto imageRequestDto) throws IOException {
        IntroBoard introBoard = new IntroBoard();
        // imageRequestDto를 List<Image> 타입으로 변환 / 게시판 정보도 함께 포함해서 저장시킴
        List<Image> imageList = new Image().toList(imageRequestDto, introBoard);

        // introBoardRequestDto를 introBoard 타입으로 변환
        introBoard.setIntroBoard(introBoardRequestDto);

        // introBoard를 저장
        introBoardRepository.save(introBoard);


        List<Image> savedImage = imageRepository.saveAll(imageList);


        System.out.println(savedImage);

        List<Long> imageIds = new ArrayList<>();

        for(Image image: savedImage) {
            imageIds.add(image.getId());
        }

        IntroBoardResponseDto introBoardResponseDto = new IntroBoardResponseDto();
        introBoardResponseDto.setIntroBoardResponse(introBoard, imageIds);
        return introBoardResponseDto;
    }

    public IntroBoardResponseDto getBoard(Long id) {
        IntroBoard foundBoard = introBoardRepository.findById(id).orElseThrow();

        List<Image> ImageList = foundBoard.getImages();

        System.out.println(ImageList);

        List<Long> imageIds = new ArrayList<>();

        for(Image image: ImageList) {
            imageIds.add(image.getId());
        }

        IntroBoardResponseDto introBoardResponseDto = new IntroBoardResponseDto();
        introBoardResponseDto.setIntroBoardResponse(foundBoard, imageIds);
        return introBoardResponseDto;
    }
}
