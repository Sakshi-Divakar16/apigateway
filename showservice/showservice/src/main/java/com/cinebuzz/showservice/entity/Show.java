package com.cinebuzz.showservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @Column(nullable = false)
    private Long movieId;

    @Column(nullable = false)
    private Long theatreId;

    @Column(nullable = false)
    private LocalDateTime showDatetime;

    public Show() {}

    public Show(Long movieId, Long theatreId, LocalDateTime showDatetime) {
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
