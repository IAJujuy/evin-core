package com.evin.core.event;

import com.evin.core.api.CreateEventRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EvinEventRepository repository;

    public EventService(EvinEventRepository repository) {
        this.repository = repository;
    }

    public EvinEvent createEvent(CreateEventRequest request) {

        EvinEvent event = new EvinEvent(
                request.getEntityType(),
                request.getEntityId(),
                request.getEventType(),
                request.getSource(),
                request.getOccurredAt(),
                request.getPayload()
        );

        return repository.save(event);
    }

    public List<EvinEvent> getEvents(String entityType, String entityId) {
        return repository.findByEntityTypeAndEntityIdOrderByOccurredAtAsc(entityType, entityId);
    }
}