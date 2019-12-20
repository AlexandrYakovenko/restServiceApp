package com.rest.service;

import com.rest.entity.Exhibition;
import com.rest.repository.ExhibitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionService {
    private ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public Optional<List<Exhibition>> findAll() {
        return Optional.of(exhibitionRepository.findAll());
    }

    public Optional<Exhibition> findExhibitionById(Long id) {
        return exhibitionRepository.findById(id);
    }

    public Optional<Exhibition> save(Exhibition exhibition) {
        return Optional.of(exhibitionRepository.save(exhibition));
    }

    public Optional<Exhibition> updateExhibition(Long id, Exhibition exhibition) {
        exhibition.setId(id);
        return exhibitionRepository.findById(id).isPresent()
                ? Optional.of(exhibitionRepository.save(exhibition))
                : Optional.empty();
    }

    public void deleteExhibition(Long id) {
        exhibitionRepository.findById(id).ifPresent((i) -> exhibitionRepository.delete(i));
    }
}
