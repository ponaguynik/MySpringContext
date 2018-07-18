package org.myspring.context;

import java.util.EventObject;

/**
 * Class to be extended by all application events.
 */
public abstract class ApplicationEvent extends EventObject {
    /** System time when the event happened */
    private final long timestamp;

    public ApplicationEvent(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }

    public final long getTimestamp() {
        return timestamp;
    }
}
