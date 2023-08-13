package org.elliot.GlasgowDataAggregator.service.aggregator;

import reactor.core.publisher.Mono;

public interface DataService<T> {
    Mono<T> getData();
}
