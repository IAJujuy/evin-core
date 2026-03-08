package com.evin.core.api;

import com.evin.core.event.EvinEvent;
import com.evin.core.event.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EvinEvent createEvent(@RequestBody EvinEvent event) {
        return eventService.save(event);
    }

    @GetMapping("/{entityType}/{entityId}")
    public List<EvinEvent> getEventsByEntity(@PathVariable String entityType,
                                             @PathVariable String entityId) {
        return eventService.findByEntity(entityType, entityId);
    }
}