package com.pk.structural.consumer;

@FunctionalInterface
public interface Consumer<T> {
    void process(T t);

    /**
     * since the interface is Functional interface, we need to add a default method definition for andThen
     * so that the compilation will be successful.
     */
    default Consumer<T> andThen(Consumer<T> anotherConsumer) {
        return (T t) -> {
            this.process(t);
            anotherConsumer.process(t);
        };
    }
}
