package com.cinebuzz.showservice.service;

import com.cinebuzz.showservice.dto.ShowDto;

import java.util.List;

public interface ShowService {
    ShowDto createShow(ShowDto showDto);
    ShowDto getShowById(Long showId);
    List<ShowDto> getAllShows();
    ShowDto updateShow(Long showId, ShowDto showDto);
    void deleteShow(Long showId);
    boolean doesShowExist(Long showId);

}
