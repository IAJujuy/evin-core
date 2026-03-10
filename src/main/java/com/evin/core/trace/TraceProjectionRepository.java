package com.evin.core.trace;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraceProjectionRepository extends JpaRepository<TraceProjection, Long> {

    Optional<TraceProjection> findByEntityTypeAndEntityId(String entityType, String entityId);

}