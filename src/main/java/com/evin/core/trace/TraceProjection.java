package com.evin.core.trace;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(
        name = "evin_trace_projection",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_entity", columnNames = {"entity_type", "entity_id"})
        }
)
public class TraceProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type", nullable = false, length = 60)
    private String entityType;

    @Column(name = "entity_id", nullable = false, length = 80)
    private String entityId;

    @Column(name = "last_event_type", nullable = false, length = 80)
    private String lastEventType;

    @Column(name = "last_event_time", nullable = false)
    private Instant lastEventTime;

    @Column(name = "last_payload", columnDefinition = "json")
    private String lastPayload;

    protected TraceProjection() {
        // JPA
    }

    public TraceProjection(String entityType,
                           String entityId,
                           String lastEventType,
                           Instant lastEventTime,
                           String lastPayload) {
        this.entityType = entityType;
        this.entityId = entityId;
        this.lastEventType = lastEventType;
        this.lastEventTime = lastEventTime;
        this.lastPayload = lastPayload;
    }

    public Long getId() {
        return id;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getLastEventType() {
        return lastEventType;
    }

    public Instant getLastEventTime() {
        return lastEventTime;
    }

    public String getLastPayload() {
        return lastPayload;
    }

    public void updateFromEvent(String lastEventType,
                                Instant lastEventTime,
                                String lastPayload) {
        this.lastEventType = lastEventType;
        this.lastEventTime = lastEventTime;
        this.lastPayload = lastPayload;
    }
}