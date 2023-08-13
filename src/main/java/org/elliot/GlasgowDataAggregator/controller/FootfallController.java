package org.elliot.GlasgowDataAggregator.controller;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.service.data.GlasgowFootfallSiteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/footfall")
public class FootfallController {

    private final GlasgowFootfallSiteService glasgowFootfallSiteService;

    public FootfallController(GlasgowFootfallSiteService glasgowFootfallSiteService) {
        this.glasgowFootfallSiteService = glasgowFootfallSiteService;
    }

    @GetMapping(value = "/sites", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<Site>>> getFootFallSummary() {
        return glasgowFootfallSiteService.getData();
    }
}
