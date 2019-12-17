package com.rest.service.repository;

import com.rest.service.entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
    List<Exhibition> findAll();

    Optional<Exhibition> findExhibitionById(Long id);
}
