package com.CineBuzz.theatreservice.controller;

import com.CineBuzz.theatreservice.dto.TheatreDto;
import com.CineBuzz.theatreservice.service.TheatreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public TheatreDto createTheatre(@Valid @RequestBody TheatreDto theatreDto) {
        return theatreService.createTheatre(theatreDto);
    }

    @GetMapping("/{id}")
    public TheatreDto getTheatre(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @GetMapping
    public List<TheatreDto> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PutMapping("/{id}")
    public TheatreDto updateTheatre(@PathVariable Long id, @Valid @RequestBody TheatreDto theatreDto) {
        return theatreService.updateTheatre(id, theatreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);

        // Create response message
        Map<String, String> response = new HashMap<>();
        response.put("message", "Theatre deleted successfully");

        return ResponseEntity.ok(response);
    }

}
