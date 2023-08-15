package org.elliot.GlasgowDataAggregator.service.function;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response.SiteResponse;

import java.util.function.Function;

class SiteResponseToSiteFunction implements Function<SiteResponse, Site> {

    @Override
    public Site apply(SiteResponse siteResponse) {
        return new Site.Builder(
                siteResponse.getId(),
                siteResponse.getName(),
                siteResponse.getLat(),
                siteResponse.getLon()
        ).build();
    }
}
