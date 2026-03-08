package com.evin.core.event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EvinEventRepository eventRepository;

    public EventService(EvinEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EvinEvent save(EvinEvent event) {
        return eventRepository.save(event);
    }

    public List<EvinEvent> findByEntity(String entityType, String entityId) {
        return eventRepository.findByEntityTypeAndEntityIdOrderByOccurredAtAsc(entityType, entityId);
    }
}