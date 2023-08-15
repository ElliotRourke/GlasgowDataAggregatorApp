package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MeasurementCount {
    private final LocalDateTime localTimeStamp;
    private final int count;
    private final String measurementClass;
    private final LocalDateTime timestamp;

    private MeasurementCount(Builder builder) {
        this.localTimeStamp = builder.localTimeStamp;
        this.count = builder.count;
        this.measurementClass = builder.measurementClass;
        this.timestamp = builder.timestamp;
    }

    public static class Builder {
        private final LocalDateTime localTimeStamp;
        private final int count;
        private final String measurementClass;
        private final LocalDateTime timestamp;

        public Builder(
                LocalDateTime localTimeStamp,
                int count,
                String measurementClass,
                LocalDateTime timestamp
        ) {
            this.localTimeStamp = localTimeStamp;
            this.count = count;
            this.measurementClass = measurementClass;
            this.timestamp = timestamp;
        }

        public MeasurementCount build() {
            return new MeasurementCount(this);
        }
    }
}
