package home.inuappcenter.kr.appcenterhomepagerenewalserver.service;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.Image;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.domain.board.IntroBoard;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.ImageRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.BoardRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.BoardResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository.ImageRepository;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.repository.IntroBoardRepository;
import jakarta.servlet.http.HttpServletRequest;
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
    private final HttpServletRequest request;
    // 게시글 저장하기
    public BoardResponseDto<List<Long>> saveBoard(BoardRequestDto boardRequestDto, ImageRequestDto imageRequestDto) throws IOException {
        IntroBoard introBoard = new IntroBoard();
        // imageRequestDto를 List<Image> 타입으로 변환 / 게시판 정보도 함께 포함해서 저장시킴
        List<Image> imageList = new Image().toList(imageRequestDto, introBoard);

        // introBoardRequestDto를 introBoard 타입으로 변환
        introBoard.setIntroBoard(boardRequestDto);

        // introBoard를 저장
        introBoardRepository.save(introBoard);


        List<Image> savedImage = imageRepository.saveAll(imageList);

        List<Long> imageIds = new ArrayList<>();

        for(Image image: savedImage) {
            imageIds.add(image.getId());
        }

        BoardResponseDto<List<Long>> boardResponseDto = new BoardResponseDto<>();
        boardResponseDto.setBoardResponse(introBoard, imageIds);
        return boardResponseDto;
    }

    public BoardResponseDto<List<String>> getBoard(Long id) {
        IntroBoard foundBoard = introBoardRepository.findById(id).orElseThrow();

        List<Image> ImageList = foundBoard.getImages();

        List<String> images = new ArrayList<>();

        for(Image image: ImageList) {
            images.add(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +  "/image/photo/" + image.getId().toString());
        }

        BoardResponseDto<List<String>> boardResponseDto = new BoardResponseDto<>();
        boardResponseDto.setBoardResponse(foundBoard, images);
        return boardResponseDto;
    }
}