package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

@Component
public class GlasgowFootfallSiteSupplier implements Supplier<Mono<List<Site>>> {

    private final GlasgowFootfallService glasgowFootfallService;

    public GlasgowFootfallSiteSupplier(GlasgowFootfallService glasgowFootfallService) {
        this.glasgowFootfallService = glasgowFootfallService;
    }

    @Override
    public Mono<List<Site>> get() {
        return glasgowFootfallService.getSites();
    }
}
