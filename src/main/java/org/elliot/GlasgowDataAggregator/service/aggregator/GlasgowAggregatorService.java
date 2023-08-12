package org.elliot.GlasgowDataAggregator.service.aggregator;

import org.elliot.GlasgowDataAggregator.service.gov.GlasgowFootfallService;
import org.springframework.stereotype.Service;

@Service
public class GlasgowAggregatorService implements AggregatorService<String> {

    private GlasgowFootfallService glasgowFootfallService;

    public GlasgowAggregatorService(GlasgowFootfallService glasgowFootfallService) {
        this.glasgowFootfallService = glasgowFootfallService;
    }

    @Override
    public String getData() {
        return null; //TODO:
    }
}
