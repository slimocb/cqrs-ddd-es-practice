package org.bkiebdaj.cqrsexample.message;

import lombok.RequiredArgsConstructor;
import org.bkiebdaj.cqrsexample.api.EventPayload;
import org.bkiebdaj.cqrsexample.event.store.EventStore;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMessageBus extends SimpleMessageBus<EventPayload> {

    private final EventStore eventStore;

    @Override
    public void publish(EventPayload message) {
        eventStore.save(message);
        super.publish(message);
    }
}