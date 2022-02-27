package com.pk.structural.consumer;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
    void process(T t);

    /**
     * since the interface is Functional interface, we need to add a default method definition for andThen
     * so that the compilation will be successful.
     */
    default Consumer<T> andThen(Consumer<T> anotherConsumer) {
        Objects.requireNonNull(anotherConsumer);
        return (T t) -> {
            this.process(t);
            anotherConsumer.process(t);
        };
    }
}
