package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@HttpExchange(url = "${url.gov.glasgow.footfall.base}", accept = MediaType.APPLICATION_JSON_VALUE)
public interface GlasgowFootfallMeasurementService {
    @GetExchange("/Mobility_Measurement?format=json&period={period}&type={type}&date={date}&site={site}[&end]")
    Mono<Measurement> getMobilityMeasurements(
            @PathVariable String period,
            @PathVariable String type,
            @PathVariable Date date,
            @PathVariable int site,
            @PathVariable Date end
            );
}
