package org.elliot.GlasgowDataAggregator.service.gov;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "${url.gov.glasgow.footfall.sites}", accept = MediaType.APPLICATION_JSON_VALUE)
public interface GlasgowFootfallService {
    @GetExchange("/Mobility_Sites?json")
    Mono<Site> getSites();
}
