package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall;

import lombok.Data;

@Data
public class Site {
    private String id;
    private String name;
    private String lat;
    private String lon;
}
