package com.cinebuzz.ticketservice.dto;

import java.time.LocalDateTime;

public class ShowDto {

    private Long showId;
    private Long movieId;
    private Long theatreId;
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
