package com.cinebuzz.showservice.repository;

import com.cinebuzz.showservice.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
    boolean existsByShowId(Long showId);
}

