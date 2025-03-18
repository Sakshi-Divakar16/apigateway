package com.cinebuzz.seatservice.client;

import com.cinebuzz.seatservice.dto.AddressDto;
import com.cinebuzz.seatservice.dto.TheatreDto;
import org.springframework.stereotype.Component;

@Component
public class TheatreServiceFallback implements TheatreServiceClient {

    @Override
    public TheatreDto getTheatreById(Long theatreId) {
        return new TheatreDto(
            theatreId, 
            "Unknown Theatre", 
            0, 
            0, 
            new AddressDto(0L, "N/A", "N/A", "N/A", "N/A")  // Default Address
        );
    }
}
