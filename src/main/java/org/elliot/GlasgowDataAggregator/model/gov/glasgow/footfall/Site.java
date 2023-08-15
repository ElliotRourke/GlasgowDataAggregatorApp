package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall;

import lombok.Data;
import lombok.Getter;

@Getter
public class Site {
    private final String id;
    private final String name;
    private final String lat;
    private final String lon;

    private Site(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lat = builder.lat;
        this.lon = builder.lon;
    }

    public static class Builder {
        private final String id;
        private final String name;
        private final String lat;
        private final String lon;

        public Builder(
                String id,
                String name,
                String lat,
                String lon
        ) {
            this.id = id;
            this.name = name;
            this.lat = lat;
            this.lon = lon;
        }

        public Site build() {
            return new Site(this);
        }
    }
}
