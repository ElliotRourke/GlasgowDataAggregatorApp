package org.elliot.GlasgowDataAggregator.service.supplier;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.request.MeasurementRequest;
import org.elliot.GlasgowDataAggregator.service.function.MeasurementResponseTransformer;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class GlasgowFootfallMeasurementSupplier implements Function<MeasurementRequest, Mono<Measurement>> {

    private final GlasgowFootfallMeasurementService glasgowFootfallMeasurementService;
    private final MeasurementResponseTransformer measurementResponseTransformer;

    public GlasgowFootfallMeasurementSupplier(GlasgowFootfallMeasurementService glasgowFootfallMeasurementService,
                                              MeasurementResponseTransformer measurementResponseTransformer) {
        this.glasgowFootfallMeasurementService = glasgowFootfallMeasurementService;
        this.measurementResponseTransformer = measurementResponseTransformer;
    }

    @Override
    public Mono<Measurement> apply(MeasurementRequest measurementRequest) {
        return glasgowFootfallMeasurementService.getMobilityMeasurements(
                measurementRequest.getPeriod(),
                measurementRequest.getType().toString(),
                measurementRequest.getStartDate(),
                measurementRequest.getSite(),
                measurementRequest.getEndDate()
        ).map(measurementResponseTransformer);
    }
}
