package tech.pathtoprogramming.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventPub {
    // takes 3 args javaKeyStore, jwtToken, eventPubUrl

    private String javaKeyStore;
    private String jwtToken;
    private String eventPublisherUrl;

    public EventPub(String javaKeyStore, String jwtToken, String eventPublisherUrl) {
        this.javaKeyStore = javaKeyStore;
        this.jwtToken = jwtToken;
        this.eventPublisherUrl = eventPublisherUrl;
    }

    private static final Logger log = LoggerFactory.getLogger(EventPub.class);

    public void publishEventUtil(String event) {
        log.info("Event published to queue batch-info on Kafka. Event: {}", event);
    }
}
