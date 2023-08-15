package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.service.function.SiteResponseTransformer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

@Component
public class GlasgowFootfallSiteSupplier implements Supplier<Mono<List<Site>>> {

    private final GlasgowFootfallService glasgowFootfallService;
    private final SiteResponseTransformer siteResponseTransformer;

    public GlasgowFootfallSiteSupplier(GlasgowFootfallService glasgowFootfallService,
                                       SiteResponseTransformer siteResponseTransformer) {
        this.glasgowFootfallService = glasgowFootfallService;
        this.siteResponseTransformer = siteResponseTransformer;
    }

    @Override
    public Mono<List<Site>> get() {
        return glasgowFootfallService
                .getSites()
                .map(siteResponseTransformer);
    }
}
