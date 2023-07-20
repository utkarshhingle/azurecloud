package com.utk.azurecloud.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utk.azurecloud.dto.Image;
import com.utk.azurecloud.respository.ImageRepository;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void saveImage(LocalDate birth,LocalDate death, String name, String description, byte[] imageBytes) {
        Image image = new Image(birth,death,Period.between(birth, death).getYears(), name, description, imageBytes);
        imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public byte[] getImageBytes(Long id) throws IOException {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            return image.getImageBytes();
        } else {
            throw new IOException("Image not found.");
        }
    }
}
