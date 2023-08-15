package org.elliot.GlasgowDataAggregator.service.function;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Measurement;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.request.MeasurementRequest;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response.MeasurementResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MeasurementResponseTransformer implements Function<MeasurementResponse, Measurement> {
    @Override
    public Measurement apply(MeasurementResponse measurementResponse) {
        return null; //TODO:
    }
}
