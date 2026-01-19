package com.tus.flight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class LogTestController {

    private static final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/log")
    public String logTest() {
        log.info("TEST LOG — Flight service logging pipeline active");
        log.warn("TEST WARN — Kibana observability check");
        log.error("TEST ERROR — Elasticsearch ingestion verification");
        return "Logs emitted";
    }
}
