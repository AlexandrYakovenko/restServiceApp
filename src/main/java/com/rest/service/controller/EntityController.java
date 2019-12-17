package com.rest.service.controller;

import com.rest.service.entity.Exhibition;
import com.rest.service.repository.ExhibitionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EntityController {

    @Resource
    private ExhibitionRepository exhibitionRepository;

    @GetMapping("/exhibitions/{exhibitionId}")
    public ResponseEntity<Exhibition> getExhibition(@PathVariable Long exhibitionId) {
        return ResponseEntity.of(exhibitionRepository.findExhibitionById(exhibitionId));
    }
}
