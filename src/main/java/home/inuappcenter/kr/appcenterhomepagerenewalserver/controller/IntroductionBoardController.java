package home.inuappcenter.kr.appcenterhomepagerenewalserver.controller;

import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.ImageRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.request.IntroBoardRequestDto;
import home.inuappcenter.kr.appcenterhomepagerenewalserver.data.dto.response.IntroBoardResponseDto;
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

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public ResponseEntity<IntroBoardResponseDto<List<Long>>> uploadImageToFileSystem(@RequestPart(value = "multipartFileList", required = false) List<MultipartFile> multipartFileList,
                                                                         @RequestPart(value = "introBoardRequestDto") IntroBoardRequestDto introBoardRequestDto ) throws IOException {

        ImageRequestDto imageRequestDto = new ImageRequestDto(multipartFileList);
        IntroBoardResponseDto<List<Long>> introBoardResponseDto = introBoardService.saveBoard(introBoardRequestDto, imageRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(introBoardResponseDto);
    }

    @GetMapping
    public ResponseEntity<IntroBoardResponseDto<List<String>>> getBoard(Long id) {
        IntroBoardResponseDto<List<String>> introBoardResponseDto = introBoardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(introBoardResponseDto);
    }
}

