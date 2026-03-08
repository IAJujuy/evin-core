package com.evin.core.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class CreateEventRequest {

    @NotBlank
    private String entityType;

    @NotBlank
    private String entityId;

    @NotBlank
    private String eventType;

    @NotBlank
    private String source;

    @NotNull
    private Instant occurredAt;

    private String payload;

    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Instant getOccurredAt() { return occurredAt; }
    public void setOccurredAt(Instant occurredAt) { this.occurredAt = occurredAt; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
}