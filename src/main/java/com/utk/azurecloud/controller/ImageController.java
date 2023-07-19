package com.utk.azurecloud.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utk.azurecloud.dto.Image;
import com.utk.azurecloud.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
	@CrossOrigin(origins ="*")
    public ResponseEntity<String> uploadImage(
            @RequestParam("age") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime age,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image) {
        try {
            // Save the image using the imageService
            imageService.saveImage(age.toLocalDate(), name, description, image.getBytes());
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while uploading the image.");
        }
    }
    
    @GetMapping
	@CrossOrigin(origins ="*")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }
    
    @GetMapping("/{id}/image")
	@CrossOrigin(origins ="*")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            byte[] imageData = imageService.getImageBytes(id);
            return ResponseEntity.ok(imageData);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
