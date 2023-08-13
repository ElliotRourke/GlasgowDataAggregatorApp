package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@HttpExchange(url = "${url.gov.glasgow.footfall.base}", accept = MediaType.APPLICATION_JSON_VALUE)
public interface GlasgowFootfallService {
    @GetExchange("/Mobility_Sites?json")
    Mono<List<Site>> getSites();
}