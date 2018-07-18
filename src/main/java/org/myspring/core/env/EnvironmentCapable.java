package org.myspring.core.env;

/**
 * Interface indicating a component that contains and exposes an {@link Environment} reference.
 */
public interface EnvironmentCapable {

    /**
     * Return the {@link Environment} associated with this component.
     */
    Environment getEnvironment();
}
