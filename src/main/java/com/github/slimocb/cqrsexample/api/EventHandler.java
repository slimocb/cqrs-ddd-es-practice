package com.github.slimocb.cqrsexample.api;

public interface EventHandler<T extends EventPayload> {
    void handle(T event);
}
