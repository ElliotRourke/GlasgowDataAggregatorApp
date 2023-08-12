package org.elliot.GlasgowDataAggregator.controller;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@RequestMapping("/api")
public @interface PublicApiController {
    @AliasFor(annotation = Component.class)
    String value() default "";
}