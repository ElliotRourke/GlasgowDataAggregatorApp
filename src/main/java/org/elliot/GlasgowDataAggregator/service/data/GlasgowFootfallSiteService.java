package org.elliot.GlasgowDataAggregator.service.data;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.service.function.ResponseEntityWrapperFunction;
import org.elliot.GlasgowDataAggregator.service.supplier.GlasgowFootfallSiteSupplier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GlasgowFootfallSiteService implements DataService<ResponseEntity<List<Site>>> {

    private final GlasgowFootfallSiteSupplier glasgowFootfallSiteSupplier;
    private final ResponseEntityWrapperFunction<List<Site>> responseEntityWrapperFunction;

    public GlasgowFootfallSiteService(GlasgowFootfallSiteSupplier glasgowFootfallSiteSupplier,
                                      ResponseEntityWrapperFunction<List<Site>> responseEntityWrapperFunction) {
        this.glasgowFootfallSiteSupplier = glasgowFootfallSiteSupplier;
        this.responseEntityWrapperFunction = responseEntityWrapperFunction;
    }

    @Override
    public Mono<ResponseEntity<List<Site>>> getData() {
        return glasgowFootfallSiteSupplier
                .get()
                .map(responseEntityWrapperFunction);
    }
}
