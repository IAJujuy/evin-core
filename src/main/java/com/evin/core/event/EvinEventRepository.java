package com.evin.core.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvinEventRepository extends JpaRepository<EvinEvent, Long> {

    List<EvinEvent> findByEntityTypeAndEntityIdOrderByOccurredAtAsc(String entityType, String entityId);

}