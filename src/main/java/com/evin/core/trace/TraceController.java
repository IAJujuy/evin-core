package com.evin.core.api;

import com.evin.core.trace.TraceProjection;
import com.evin.core.trace.TraceQueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trace")
public class TraceController {

    private final TraceQueryService traceQueryService;

    public TraceController(TraceQueryService traceQueryService) {
        this.traceQueryService = traceQueryService;
    }

    @GetMapping("/{entityType}/{entityId}")
    public TraceProjection getTrace(@PathVariable String entityType,
                                    @PathVariable String entityId) {
        return traceQueryService.getTrace(entityType, entityId);
    }
}