package org.elliot.GlasgowDataAggregator.config.web;

import org.elliot.GlasgowDataAggregator.service.supplier.GlasgowCycleAndPedestrianCountService;
import org.elliot.GlasgowDataAggregator.service.supplier.GlasgowFootfallService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpProxyConfig {

    @Bean
    GlasgowFootfallService glasgowFootfallService(WebClient webClient, ConfigurableBeanFactory configurableBeanFactory) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .embeddedValueResolver(configurableBeanFactory::resolveEmbeddedValue)
                .build();
        return factory.createClient(GlasgowFootfallService.class);
    }

    @Bean
    GlasgowCycleAndPedestrianCountService glasgowCycleAndPedestrianCountService(WebClient webClient, ConfigurableBeanFactory configurableBeanFactory) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .embeddedValueResolver(configurableBeanFactory::resolveEmbeddedValue)
                .build();
        return factory.createClient(GlasgowCycleAndPedestrianCountService.class);
    }

}
