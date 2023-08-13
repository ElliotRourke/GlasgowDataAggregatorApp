package org.elliot.GlasgowDataAggregator.service.data;

import reactor.core.publisher.Mono;

public interface DataService<T> {
    Mono<T> getData();
}
