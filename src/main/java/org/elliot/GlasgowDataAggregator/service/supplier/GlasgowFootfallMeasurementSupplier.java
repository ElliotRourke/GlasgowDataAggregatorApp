package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.MeasurementRequest;
import reactor.core.publisher.Mono;

import java.util.function.Function;

//TODO: Not sure how I feel about using Function interface here as a "supplier"
public class GlasgowFootfallMeasurementSupplier implements Function<MeasurementRequest, Mono<Measurement>> {

    private final GlasgowFootfallMeasurementService glasgowFootfallMeasurementService;

    public GlasgowFootfallMeasurementSupplier(GlasgowFootfallMeasurementService glasgowFootfallMeasurementService) {
        this.glasgowFootfallMeasurementService = glasgowFootfallMeasurementService;
    }

    @Override
    public Mono<Measurement> apply(MeasurementRequest measurementRequest) {
        return glasgowFootfallMeasurementService.getMobilityMeasurements(
                measurementRequest.getPeriod(),
                measurementRequest.getType().toString(),
                measurementRequest.getStartDate(),
                measurementRequest.getSite(),
                measurementRequest.getEndDate()
        );
    }

    @Override
    public <V> Function<V, Mono<Measurement>> compose(Function<? super V, ? extends MeasurementRequest> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<MeasurementRequest, V> andThen(Function<? super Mono<Measurement>, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
