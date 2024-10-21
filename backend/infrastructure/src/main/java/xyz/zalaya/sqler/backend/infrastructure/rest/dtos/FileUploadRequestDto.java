package xyz.zalaya.sqler.backend.infrastructure.rest.dtos;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequestDto(MultipartFile file) {

    public boolean isEmpty() {
        return file.isEmpty();
    }

}
