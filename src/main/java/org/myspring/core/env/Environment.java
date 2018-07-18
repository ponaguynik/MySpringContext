package org.myspring.core.env;

/**
 * Interface representing the environment in which the current application is running.
 * Models two key aspects of the application environment: <em>profiles</em> and
 * <em>properties</em>. Methods related to property access are exposed via the
 * {@link PropertyResolver} superinterface.
 */
public interface Environment extends PropertyResolver {

    /**
     * Return the set of profiles explicitly made active for this environment.
     * <p>If no profiles have explicitly been specified as active, then any
     * {@linkplain #getDefaultProfiles() default profiles} will automatically be activated</p>
     */
    String[] getActiveProfiles();

    /**
     * Return the set of profiles to be activated by default when no active profiles have
     * been set explicitly.
     */
    String[] getDefaultProfiles();

    /**
     * Return whether one or more of the given profiles is active.
     *
     * @throws IllegalArgumentException if called with zero arguments
     *                                  or if any profile is {@code null}, empty or whitespace-only
     */
    boolean acceptsProfiles(String... profiles);
}
