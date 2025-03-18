package com.cinebuzz.movieservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MovieDto {
    
    private Long movieId;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int duration;

    @NotNull(message = "Ticket price is required")
    @Min(value = 1, message = "Ticket price must be at least 1")
    private double ticketBasePrice;

    // Getters and Setters
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public double getTicketBasePrice() { return ticketBasePrice; }
    public void setTicketBasePrice(double ticketBasePrice) { this.ticketBasePrice = ticketBasePrice; }
}
