package org.elliot.GlasgowDataAggregator.controller;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.request.FootfallType;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.service.data.GlasgowFootfallMeasurementService;
import org.elliot.GlasgowDataAggregator.service.data.GlasgowFootfallSiteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/footfall")
public class FootfallController {

    private final GlasgowFootfallSiteService glasgowFootfallSiteService;
    private final GlasgowFootfallMeasurementService glasgowFootfallMeasurementService;

    public FootfallController(GlasgowFootfallSiteService glasgowFootfallSiteService,
                              GlasgowFootfallMeasurementService glasgowFootfallMeasurementService) {
        this.glasgowFootfallSiteService = glasgowFootfallSiteService;
        this.glasgowFootfallMeasurementService = glasgowFootfallMeasurementService;
    }

    @GetMapping(value = "/sites", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<Site>>> getFootfallSites() {
        return glasgowFootfallSiteService.getData();
    }

    @GetMapping(value = "/measurement", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Measurement>> getFootfallMeasurementForSite(
            @RequestParam String period,
            @RequestParam final String type,
            @RequestParam final Date startDate,
            @RequestParam final int site,
            @RequestParam final Date endDate
    ) {
        return glasgowFootfallMeasurementService.getData(period, FootfallType.valueOf(type), startDate, site, endDate);
    }
}
