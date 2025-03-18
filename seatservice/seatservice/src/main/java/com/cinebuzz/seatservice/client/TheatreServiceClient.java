package com.cinebuzz.seatservice.client;

import com.cinebuzz.seatservice.client.TheatreServiceFallback;
import com.cinebuzz.seatservice.dto.TheatreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theatreservice", fallback = TheatreServiceFallback.class)
public interface TheatreServiceClient {

    @GetMapping("/api/theatres/{theatreId}")
    TheatreDto getTheatreById(@PathVariable Long theatreId);
}
