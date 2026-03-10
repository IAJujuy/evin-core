package com.evin.core.trace;

import com.evin.core.event.EvinEvent;
import org.springframework.stereotype.Service;

@Service
public class TraceProjectionService {

    private final TraceProjectionRepository repository;

    public TraceProjectionService(TraceProjectionRepository repository) {
        this.repository = repository;
    }

    public void applyEvent(EvinEvent event) {
        TraceProjection projection = repository
                .findByEntityTypeAndEntityId(event.getEntityType(), event.getEntityId())
                .orElseGet(() -> new TraceProjection(
                        event.getEntityType(),
                        event.getEntityId(),
                        event.getEventType(),
                        event.getOccurredAt(),
                        event.getPayload()
                ));

        projection.updateFromEvent(
                event.getEventType(),
                event.getOccurredAt(),
                event.getPayload()
        );

        repository.save(projection);
    }
}