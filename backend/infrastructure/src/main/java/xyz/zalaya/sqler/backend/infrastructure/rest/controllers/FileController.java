package xyz.zalaya.sqler.backend.infrastructure.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.zalaya.sqler.backend.infrastructure.rest.dtos.FileUploadRequestDto;

@RestController
@RequestMapping("${file.controller.context}")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam("fileUploadRequest") FileUploadRequestDto fileUploadRequestDto) {
        if (fileUploadRequestDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
