package org.elliot.GlasgowDataAggregator.service.function;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.MeasurementCount;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response.MeasurementResponse;

import java.util.function.Function;

public class MeasurementResponseCountToMeasurementCountFunction implements Function<MeasurementResponse.Count, MeasurementCount> {
    @Override
    public MeasurementCount apply(MeasurementResponse.Count count) {
        return new MeasurementCount.Builder(
                count.getLocalTimeStamp(),
                count.getCount(),
                count.getMeasurementClass(),
                count.getTimestamp()
        ).build();
    }
}
