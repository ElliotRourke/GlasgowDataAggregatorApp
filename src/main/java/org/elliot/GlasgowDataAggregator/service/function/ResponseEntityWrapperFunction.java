package org.elliot.GlasgowDataAggregator.service.function;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResponseEntityWrapperFunction<T> implements Function<T, ResponseEntity<T>> {

    @Override
    public ResponseEntity<T> apply(T t) {
        return new ResponseEntity<>(t, HttpStatusCode.valueOf(200));
    }

    @Override
    public <V> Function<V, ResponseEntity<T>> compose(Function<? super V, ? extends T> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<T, V> andThen(Function<? super ResponseEntity<T>, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
