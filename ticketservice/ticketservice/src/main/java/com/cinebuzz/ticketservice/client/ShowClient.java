package com.cinebuzz.ticketservice.client;

import com.cinebuzz.ticketservice.dto.ShowDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "showservice", path = "/api/shows")
public interface ShowClient {

    @GetMapping("/{showId}")
    ShowDto getShowById(@PathVariable Long showId);
}
