package com.cinebuzz.showservice.controller;

import com.cinebuzz.showservice.dto.ShowDto;
import com.cinebuzz.showservice.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<ShowDto> createShow(@Valid @RequestBody ShowDto showDto) {
        ShowDto createdShow = showService.createShow(showDto);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowDto> getShowById(@PathVariable Long id) {
        ShowDto show = showService.getShowById(id);
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShowDto>> getAllShows() {
        List<ShowDto> shows = showService.getAllShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowDto> updateShow(@PathVariable Long id, @Valid @RequestBody ShowDto showDto) {
        ShowDto updatedShow = showService.updateShow(id, showDto);
        return new ResponseEntity<>(updatedShow, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return new ResponseEntity<>("Show deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{showId}/exists")
    public ResponseEntity<Boolean> doesShowExist(@PathVariable Long showId) {
        return ResponseEntity.ok(showService.doesShowExist(showId));
    }
}
