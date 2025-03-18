package com.cinebuzz.offerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "showservice", path = "/api/shows")
public interface ShowServiceClient {
    @GetMapping("/{showId}/exists")
    Boolean doesShowExist(@PathVariable Long showId);
}
