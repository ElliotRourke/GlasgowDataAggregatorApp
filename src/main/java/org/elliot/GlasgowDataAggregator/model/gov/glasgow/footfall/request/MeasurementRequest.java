package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class MeasurementRequest {

    private final String period;
    private final FootfallType type;
    private final Date startDate;
    private final int site;
    private final Date endDate;

    private MeasurementRequest(Builder builder) {
        this.period = builder.period;
        this.type = builder.type;
        this.startDate = builder.date;
        this.site = builder.site;
        this.endDate = builder.end;
    }

    public static class Builder {
        private final String period;
        private final FootfallType type;
        private final Date date;
        private final int site;
        private final Date end;

        public Builder(
                String period,
                FootfallType type,
                Date date,
                int site,
                Date end
        ) {
            this.period = period;
            this.type = type;
            this.date = date;
            this.site = site;
            this.end = end;
        }

        public MeasurementRequest build() {
            return new MeasurementRequest(this);
        }
    }
}
