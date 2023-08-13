package org.elliot.GlasgowDataAggregator.service.data;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.FootfallType;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.MeasurementRequest;
import org.elliot.GlasgowDataAggregator.service.function.ResponseEntityWrapperFunction;
import org.elliot.GlasgowDataAggregator.service.supplier.GlasgowFootfallMeasurementSupplier;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.Date;

public class GlasgowFootfallMeasurementService {

    private final GlasgowFootfallMeasurementSupplier glasgowFootfallMeasurementSupplier;
    private final ResponseEntityWrapperFunction<Measurement> responseEntityWrapperFunction;

    public GlasgowFootfallMeasurementService(GlasgowFootfallMeasurementSupplier glasgowFootfallMeasurementSupplier,
                                             ResponseEntityWrapperFunction<Measurement> responseEntityWrapperFunction) {
        this.glasgowFootfallMeasurementSupplier = glasgowFootfallMeasurementSupplier;
        this.responseEntityWrapperFunction = responseEntityWrapperFunction;
    }

    public Mono<ResponseEntity<Measurement>> getData(
            String period,
            FootfallType type,
            Date startDate,
            int site,
            Date endDate
            ) {
        MeasurementRequest measurementRequest = new MeasurementRequest
                .Builder(period, type, startDate, site, endDate)
                .build();
        return glasgowFootfallMeasurementSupplier
                .apply(measurementRequest)
                .map(responseEntityWrapperFunction); //TODO: do any processing here
    }
}
