package com.CineBuzz.theatreservice.service;

import com.CineBuzz.theatreservice.dto.TheatreDto;

import java.util.List;

public interface TheatreService {
    TheatreDto createTheatre(TheatreDto theatreDto);
    TheatreDto getTheatreById(Long id);
    List<TheatreDto> getAllTheatres();
    TheatreDto updateTheatre(Long id, TheatreDto theatreDto);
    void deleteTheatre(Long id);
}
