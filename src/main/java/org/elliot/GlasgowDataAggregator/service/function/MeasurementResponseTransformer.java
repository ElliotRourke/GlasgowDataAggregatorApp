package org.elliot.GlasgowDataAggregator.service.function;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.MeasurementCount;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response.MeasurementResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MeasurementResponseTransformer implements Function<MeasurementResponse, Measurement> {
    private static final MeasurementResponseCountToMeasurementCountFunction RESPONSE_COUNT_TO_MEASUREMENT_COUNT_FUNCTION
            = new MeasurementResponseCountToMeasurementCountFunction();
    @Override
    public Measurement apply(MeasurementResponse measurementResponse) {
        List<MeasurementCount> counts = measurementResponse.getCrossingCountPerTimeInterval()
                .stream()
                .map(RESPONSE_COUNT_TO_MEASUREMENT_COUNT_FUNCTION)
                .toList();
        return new Measurement.Builder(
                measurementResponse.getEntity(),
                measurementResponse.getMeasurementClass(),
                measurementResponse.getId(),
                measurementResponse.getSiteId(),
                measurementResponse.getPartitionKey(),
                measurementResponse.getPeriodKey(),
                measurementResponse.getPeriodKeyDt(),
                counts
        ).build();
    }
}
