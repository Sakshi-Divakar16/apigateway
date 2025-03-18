package com.CineBuzz.theatreservice.repository;

import com.CineBuzz.theatreservice.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
