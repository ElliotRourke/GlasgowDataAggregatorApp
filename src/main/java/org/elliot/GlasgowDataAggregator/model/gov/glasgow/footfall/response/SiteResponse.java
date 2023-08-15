package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response;

import lombok.Data;

@Data
public class SiteResponse {
    private String id;
    private String name;
    private String lat;
    private String lon;
}
