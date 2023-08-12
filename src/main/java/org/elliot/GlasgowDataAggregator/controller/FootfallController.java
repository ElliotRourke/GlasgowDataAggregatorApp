package org.elliot.GlasgowDataAggregator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@PublicApiController()
@RequestMapping("/footfall")
public class FootfallController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> getFootFallSummary() {
        return new HashMap<>();
    }

}
