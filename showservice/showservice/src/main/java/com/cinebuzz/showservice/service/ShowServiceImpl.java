package com.cinebuzz.showservice.service;


import com.cinebuzz.showservice.dto.ShowDto;
import com.cinebuzz.showservice.entity.Show;
import com.cinebuzz.showservice.exception.ResourceNotFoundException;
import com.cinebuzz.showservice.repository.ShowRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShowDto createShow(ShowDto showDto) {
        Show show = modelMapper.map(showDto, Show.class);
        Show savedShow = showRepository.save(show);
        return modelMapper.map(savedShow, ShowDto.class);
    }

    @Override
    public ShowDto getShowById(Long showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with ID: " + showId));
        return modelMapper.map(show, ShowDto.class);
    }

    @Override
    public List<ShowDto> getAllShows() {
        return showRepository.findAll().stream()
                .map(show -> modelMapper.map(show, ShowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowDto updateShow(Long showId, ShowDto showDto) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found"));

        show.setMovieId(showDto.getMovieId());
        show.setTheatreId(showDto.getTheatreId());
        show.setShowDatetime(showDto.getShowDatetime());

        Show updatedShow = showRepository.save(show);
        return modelMapper.map(updatedShow, ShowDto.class);
    }

    @Override
    public void deleteShow(Long showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found"));
        showRepository.delete(show);
    }

    @Override
    public boolean doesShowExist(Long showId) {
        return showRepository.existsByShowId(showId);
    }

}
