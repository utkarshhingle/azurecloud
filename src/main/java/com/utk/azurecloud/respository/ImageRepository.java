package com.utk.azurecloud.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utk.azurecloud.dto.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
