package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall;

import lombok.Getter;

import java.util.List;

@Getter
public class Measurement {
    private final String entity;
    private final String measurementClass;
    private final String id;
    private final int siteId;
    private final String partitionKey;
    private final String periodKey;
    private final String periodKeyDt;
    private final List<MeasurementCount> crossingCountPerTimeInterval;

    private Measurement(Builder builder) {
        this.entity = builder.entity;
        this.measurementClass = builder.measurementClass;
        this.id = builder.id;
        this.siteId = builder.siteId;
        this.partitionKey = builder.partitionKey;
        this.periodKey = builder.periodKey;
        this.periodKeyDt = builder.periodKeyDt;
        this.crossingCountPerTimeInterval = builder.crossingCountPerTimeInterval;
    }

    public static class Builder {
        private final String entity;
        private final String measurementClass;
        private final String id;
        private final int siteId;
        private final String partitionKey;
        private final String periodKey;
        private final String periodKeyDt;
        private final List<MeasurementCount> crossingCountPerTimeInterval;

        public Builder (
                String entity,
                String measurementClass,
                String id,
                int siteId,
                String partitionKey,
                String periodKey,
                String periodKeyDt,
                List<MeasurementCount> crossingCountPerTimeInterval
        ) {
            this.entity = entity;
            this.measurementClass = measurementClass;
            this.id = id;
            this.siteId = siteId;
            this.partitionKey = partitionKey;
            this.periodKey = periodKey;
            this.periodKeyDt = periodKeyDt;
            this.crossingCountPerTimeInterval = crossingCountPerTimeInterval;
        }

        public Measurement build() {
            return new Measurement(this);
        }
    }
}
