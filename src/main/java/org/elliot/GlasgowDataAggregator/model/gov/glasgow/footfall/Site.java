package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall;

import lombok.Data;

@Data
public class Site {
    String id;
    String name;
    String lat;
    String lon;
}
