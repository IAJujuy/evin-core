package com.evin.core.event;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "evin_events")
public class EvinEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type", nullable = false, length = 60)
    private String entityType;

    @Column(name = "entity_id", nullable = false, length = 80)
    private String entityId;

    @Column(name = "event_type", nullable = false, length = 80)
    private String eventType;

    @Column(name = "source", nullable = false, length = 80)
    private String source;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;

    @Column(name = "recorded_at", nullable = false, insertable = false, updatable = false)
    private Instant recordedAt;

    @Column(name = "payload", columnDefinition = "json")
    private String payload;

    protected EvinEvent() {
        // JPA
    }

    public EvinEvent(String entityType,
                     String entityId,
                     String eventType,
                     String source,
                     Instant occurredAt,
                     String payload) {

        this.entityType = entityType;
        this.entityId = entityId;
        this.eventType = eventType;
        this.source = source;
        this.occurredAt = occurredAt;
        this.payload = payload;
    }

    public Long getId() { return id; }
    public String getEntityType() { return entityType; }
    public String getEntityId() { return entityId; }
    public String getEventType() { return eventType; }
    public String getSource() { return source; }
    public Instant getOccurredAt() { return occurredAt; }
    public Instant getRecordedAt() { return recordedAt; }
    public String getPayload() { return payload; }
}