package xyz.zalaya.sqler.backend.infrastructure.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("${file.controller.context}")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam(name = "file") MultipartFile file) {
        if (file.getOriginalFilename() == null || file.getOriginalFilename().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
