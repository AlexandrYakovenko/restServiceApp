package com.rest.controller;

import com.rest.entity.Exhibition;
import com.rest.service.ExhibitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EntityController {
    private ExhibitionService exhibitionService;

    public EntityController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping("/exhibitions")
    public ResponseEntity<List<Exhibition>> getAllExhibitions() {
        return ResponseEntity.of(exhibitionService.findAll());
    }

    @GetMapping("/exhibitions/{exhibitionId}")
    public ResponseEntity<Exhibition> getExhibition(@PathVariable Long exhibitionId) {
        return ResponseEntity.of(exhibitionService.findExhibitionById(exhibitionId));
    }

    @PostMapping("/exhibitions")
    public ResponseEntity<Exhibition> postMethod(@RequestBody Exhibition exhibition) {
        return ResponseEntity.of(exhibitionService.save(exhibition));
    }

    @PutMapping("/exhibitions/{exhibitionID}")
    public ResponseEntity<Exhibition> putMethod(@PathVariable Long exhibitionId,
                                                @RequestBody Exhibition exhibition) {
        return ResponseEntity.of(exhibitionService.updateExhibition(exhibitionId, exhibition));
    }

    @DeleteMapping("/exhibitions/{exhibitionId}")
    public void deleteMethod(@PathVariable Long exhibitionId) {
        try {
            exhibitionService.deleteExhibition(exhibitionId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
