package com.iSystem.image.controller;

import com.iSystem.image.imageDto.ImageDto;
import org.springframework.web.multipart.MultipartFile;
import com.iSystem.image.exception.ImageException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.iSystem.image.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import lombok.AllArgsConstructor;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/image")
@AllArgsConstructor
public class ImageController {
    private ImageService imageService;

    @PostMapping("/create")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        ImageDto result = imageService.saveToSystem(file);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/load/{filename:.+}")
    public @ResponseBody ResponseEntity<?> saveFile(@PathVariable String filename) throws IOException {
        Resource file = imageService.load(filename);
        return ResponseEntity.ok().header("Content-Disposition",
                "attachment; filename=" + "image.png").body(file);
    }

    @GetMapping(value = "/get/{link:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public
    @ResponseBody
    byte[] getImage(@PathVariable("link") String link) {
        if (link != null && link.length() > 0) {
            try {
                return imageService.getImg(link);
            } catch (Exception e) {
                throw new ImageException("Image not found");
            }
        }
        return null;
    }
}
