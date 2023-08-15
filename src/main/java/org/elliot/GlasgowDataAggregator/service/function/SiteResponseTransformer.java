package org.elliot.GlasgowDataAggregator.service.function;

import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.Site;
import org.elliot.GlasgowDataAggregator.model.gov.glasgow.footfall.response.SiteResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SiteResponseTransformer implements Function<List<SiteResponse>, List<Site>> {
    private static final SiteResponseToSiteFunction SITE_RESPONSE_TO_SITE_FUNCTION = new SiteResponseToSiteFunction();
    @Override
    public List<Site> apply(List<SiteResponse> sites) {
        return sites.stream()
                .map(SITE_RESPONSE_TO_SITE_FUNCTION)
                .toList();
    }
}
