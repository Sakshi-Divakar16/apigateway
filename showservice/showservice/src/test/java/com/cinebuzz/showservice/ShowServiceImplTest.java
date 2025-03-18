package com.cinebuzz.showservice;


import com.cinebuzz.showservice.dto.ShowDto;
import com.cinebuzz.showservice.entity.Show;
import com.cinebuzz.showservice.exception.ResourceNotFoundException;
import com.cinebuzz.showservice.repository.ShowRepository;
import com.cinebuzz.showservice.service.ShowServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShowServiceImplTest {

    @Mock
    private ShowRepository showRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ShowServiceImpl showService;

    private Show show;
    private ShowDto showDto;

    @BeforeEach
    void setUp() {
        show = new Show(1L, 101L, LocalDateTime.of(2025, 3, 20, 18, 30));
        showDto = new ShowDto(1L, 101L, 201L, LocalDateTime.of(2025, 3, 20, 18, 30));
    }

    /**
     * Test Case: Creating a show successfully.
     * Expected Outcome: The show is saved and returned with correct details.
     */
    @Test
    void createShow_ShouldReturnShowDto_WhenValid() {
        when(modelMapper.map(showDto, Show.class)).thenReturn(show);
        when(showRepository.save(show)).thenReturn(show);
        when(modelMapper.map(show, ShowDto.class)).thenReturn(showDto);

        ShowDto result = showService.createShow(showDto);

        assertNotNull(result);
        assertEquals(showDto.getMovieId(), result.getMovieId());
        verify(showRepository, times(1)).save(show);
    }

    /**
     * Test Case: Retrieving an existing show by ID.
     * Expected Outcome: The show is found and returned as a DTO.
     */
    @Test
    void getShowById_ShouldReturnShowDto_WhenShowExists() {
        when(showRepository.findById(1L)).thenReturn(Optional.of(show));
        when(modelMapper.map(show, ShowDto.class)).thenReturn(showDto);

        ShowDto result = showService.getShowById(1L);

        assertNotNull(result);
        assertEquals(showDto.getMovieId(), result.getMovieId());
    }

    /**
     * Test Case: Retrieving a show by ID when it does not exist.
     * Expected Outcome: ResourceNotFoundException is thrown.
     */
    @Test
    void getShowById_ShouldThrowException_WhenShowNotFound() {
        when(showRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> showService.getShowById(1L));
    }

    /**
     * Test Case: Retrieving all shows.
     * Expected Outcome: A list of ShowDto objects is returned.
     */
    @Test
    void getAllShows_ShouldReturnListOfShowDto() {
        List<Show> shows = Arrays.asList(show);
        List<ShowDto> showDtos = Arrays.asList(showDto);

        when(showRepository.findAll()).thenReturn(shows);
        when(modelMapper.map(show, ShowDto.class)).thenReturn(showDto);

        List<ShowDto> result = showService.getAllShows();

        assertEquals(1, result.size());
        assertEquals(showDto.getMovieId(), result.get(0).getMovieId());
    }

    /**
     * Test Case: Updating an existing show with valid data.
     * Expected Outcome: Show details are updated successfully.
     */
    @Test
    void updateShow_ShouldUpdateShow_WhenValidData() {
        Show updatedShow = new Show(1L, 102L, LocalDateTime.of(2025, 3, 21, 20, 00));
        ShowDto updatedShowDto = new ShowDto(1L, 102L, 202L, LocalDateTime.of(2025, 3, 21, 20, 00));

        when(showRepository.findById(1L)).thenReturn(Optional.of(show));
        when(showRepository.save(any(Show.class))).thenReturn(updatedShow);
        when(modelMapper.map(updatedShow, ShowDto.class)).thenReturn(updatedShowDto);

        ShowDto result = showService.updateShow(1L, updatedShowDto);

        assertNotNull(result);
        assertEquals(102L, result.getMovieId());
        assertEquals(202L, result.getTheatreId());
        verify(showRepository, times(1)).save(any(Show.class));
    }

    /**
     * Test Case: Updating a show that does not exist.
     * Expected Outcome: ResourceNotFoundException is thrown.
     */
    @Test
    void updateShow_ShouldThrowException_WhenShowNotFound() {
        when(showRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> showService.updateShow(1L, showDto));
    }

    /**
     * Test Case: Deleting an existing show.
     * Expected Outcome: The show is successfully deleted.
     */
    @Test
    void deleteShow_ShouldDeleteShow_WhenShowExists() {
        when(showRepository.findById(1L)).thenReturn(Optional.of(show));
        doNothing().when(showRepository).delete(show);

        assertDoesNotThrow(() -> showService.deleteShow(1L));
        verify(showRepository, times(1)).delete(show);
    }

    /**
     * Test Case: Deleting a show that does not exist.
     * Expected Outcome: ResourceNotFoundException is thrown.
     */
    @Test
    void deleteShow_ShouldThrowException_WhenShowNotFound() {
        when(showRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> showService.deleteShow(1L));
    }

    /**
     * Test Case: Checking if a show exists.
     * Expected Outcome: Returns true if show exists, false otherwise.
     */
    @Test
    void doesShowExist_ShouldReturnTrue_WhenShowExists() {
        when(showRepository.existsByShowId(1L)).thenReturn(true);

        assertTrue(showService.doesShowExist(1L));
    }

    @Test
    void doesShowExist_ShouldReturnFalse_WhenShowDoesNotExist() {
        when(showRepository.existsByShowId(1L)).thenReturn(false);

        assertFalse(showService.doesShowExist(1L));
    }
}

