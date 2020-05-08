package com.mitesh.springdata.files.repos;

import org.springframework.data.repository.CrudRepository;

import com.mitesh.springdata.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
