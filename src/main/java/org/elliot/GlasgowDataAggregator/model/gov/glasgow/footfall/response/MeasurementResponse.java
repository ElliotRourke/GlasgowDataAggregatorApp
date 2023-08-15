package org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class MeasurementResponse {
    private String entity;
    @JsonProperty("class")
    private String measurementClass;
    private String id;
    private int siteId;
    private String partitionKey;
    private String periodKey;
    private String periodKeyDt;
    private List<Count> crossingCountPerTimeInterval = new ArrayList<>();

    @Data
    public static class Count {
        private LocalDateTime localTimeStamp;
        private int count;
        @JsonProperty("class")
        private String measurementClass;
        private LocalDateTime timestamp; //UTC
    }

}
