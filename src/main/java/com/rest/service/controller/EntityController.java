package com.rest.service.controller;

import com.rest.service.entity.Exhibition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EntityController {

    private List<Exhibition> list = Arrays.asList(
            new Exhibition(1L, "Sport"),
            new Exhibition(2L, "Candies"),
            new Exhibition(3L, "Comics"),
            new Exhibition(4L, "Furs"));

    @GetMapping("/exhibitions")
    public Exhibition getExhibition(@RequestParam Long id) {
        return list.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Don't find this exhibition"));
    }
}
