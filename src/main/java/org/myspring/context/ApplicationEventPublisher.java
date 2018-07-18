package org.myspring.context;

/**
 * Interface that encapsulates event publishing functionality.
 */
@FunctionalInterface
public interface ApplicationEventPublisher {

    /**
     * Notify all <strong>matching</strong> listeners registered with this
     * application of an application event.
     *
     * @param event the event to publish
     */
    default void publishEvent(ApplicationEvent event) {
        publishEvent((Object) event);
    }

    /**
     * Notify all <strong>matching</strong> listeners registered with this
     * application of an event.
     * <p>If the specified {@code event} is not an {@link ApplicationEvent},
     * it is wrapped in a {@link PayloadApplicationEvent}.
     *
     * @param event the event to publish
     */
    void publishEvent(Object event);
}
