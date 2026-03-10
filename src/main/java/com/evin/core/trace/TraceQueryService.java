package com.evin.core.trace;

import org.springframework.stereotype.Service;

@Service
public class TraceQueryService {

    private final TraceProjectionRepository traceProjectionRepository;

    public TraceQueryService(TraceProjectionRepository traceProjectionRepository) {
        this.traceProjectionRepository = traceProjectionRepository;
    }

    public TraceProjection getTrace(String entityType, String entityId) {
        return traceProjectionRepository
                .findByEntityTypeAndEntityId(entityType, entityId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No trace projection found for entityType=" + entityType +
                                ", entityId=" + entityId
                ));
    }
}