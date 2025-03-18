package com.cinebuzz.showservice.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public class ShowDto {

    private Long showId;

    @NotNull(message = "Movie ID cannot be null")
    @Positive(message = "Movie ID must be a positive number")
    private Long movieId;

    @NotNull(message = "Theatre ID cannot be null")
    @Positive(message = "Theatre ID must be a positive number")
    private Long theatreId;

    @NotNull(message = "Show date and time cannot be null")
    @Future(message = "Show date and time must be in the future")
    private LocalDateTime showDatetime;

    public ShowDto() {}

    public ShowDto(Long showId, Long movieId, Long theatreId, LocalDateTime showDatetime) {
        this.showId = showId;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.showDatetime = showDatetime;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public LocalDateTime getShowDatetime() {
        return showDatetime;
    }

    public void setShowDatetime(LocalDateTime showDatetime) {
        this.showDatetime = showDatetime;
    }
}
