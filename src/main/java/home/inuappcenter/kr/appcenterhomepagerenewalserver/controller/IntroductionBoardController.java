package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.ImageRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.BoardRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.BoardResponseDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.service.IntroBoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/introduction-board")
public class IntroductionBoardController {

    public final IntroBoardService introBoardService;

    @GetMapping
    public ResponseEntity<BoardResponseDto<List<String>>> getBoard(Long id) {
        BoardResponseDto<List<String>> boardResponseDto = introBoardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public ResponseEntity<BoardResponseDto<List<Long>>> saveBoard(@RequestPart(value = "multipartFileList", required = false) List<MultipartFile> multipartFileList,
                                                                  @RequestPart(value = "introBoardRequestDto") BoardRequestDto boardRequestDto) throws IOException {

        ImageRequestDto imageRequestDto = new ImageRequestDto(multipartFileList);
        BoardResponseDto<List<Long>> boardResponseDto = introBoardService.saveBoard(boardRequestDto, imageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBoard(Long id) {
        String result = introBoardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}

