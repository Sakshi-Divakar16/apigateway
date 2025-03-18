package com.cinebuzz.movieservice.client;

import com.cinebuzz.movieservice.dto.TheatreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theatre-service", url = "http://localhost:8080/api/theatres")
public interface TheatreFeignClient {

    @GetMapping("/{id}")
    TheatreDto getTheatre(@PathVariable("id") Long theatreId);
}
