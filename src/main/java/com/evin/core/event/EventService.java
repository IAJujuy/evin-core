package com.evin.core.event;

import com.evin.core.api.CreateEventRequest;
import com.evin.core.trace.TraceProjectionService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class EventService {

    private final EvinEventRepository eventRepository;
    private final TraceProjectionService traceProjectionService;

    public EventService(EvinEventRepository eventRepository,
                        TraceProjectionService traceProjectionService) {
        this.eventRepository = eventRepository;
        this.traceProjectionService = traceProjectionService;
    }

    public EvinEvent createEvent(CreateEventRequest request) {
        EvinEvent event = new EvinEvent(
                request.getEntityType(),
                request.getEntityId(),
                request.getEventType(),
                request.getSource(),
                request.getOccurredAt() != null ? request.getOccurredAt() : Instant.now(),
                request.getPayload()
        );

        EvinEvent savedEvent = eventRepository.save(event);

        traceProjectionService.applyEvent(savedEvent);

        return savedEvent;
    }

    public List<EvinEvent> getEventsByEntity(String entityType, String entityId) {
        return eventRepository.findByEntityTypeAndEntityIdOrderByOccurredAtAsc(entityType, entityId);
    }
}