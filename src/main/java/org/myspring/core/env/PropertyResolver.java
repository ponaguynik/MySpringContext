package org.myspring.core.env;

import javax.annotation.Nullable;

/**
 * Interface for resolving properties against any underlying source.
 */
public interface PropertyResolver {

    /**
     * Return whether the given property key is available for resolution.
     */
    boolean containsProperty(String key);

    /**
     * Return the property value associated with the given key,
     * or {@code null} if the key cannot be resolved.
     *
     * @param key the property name to resolve
     */
    @Nullable
    String getProperty(String key);

    /**
     * Return the property value associated with the given key,
     * or {@code defaultValue} if the key cannot be resolved.
     *
     * @param key          the property name to resolve
     * @param defaultValue the default value to return if no value is found
     */
    String getProperty(String key, String defaultValue);

    @Nullable
    <T> T getProperty(String key, Class<T> targetType);

    <T> T getProperty(String key, Class<T> targetType, T defaultValue);

    /**
     * Return the property value associated with the given key (never {@code null}).
     *
     * @throws IllegalStateException if the key cannot be resolved
     */
    String getRequiredProperty(String key) throws IllegalStateException;

    @Nullable
    <T> T getRequiredProperty(String key, Class<T> targetType);

    /**
     * Resolve ${...} placeholders in the given text, replacing them with corresponding
     * property values as resolved by {@link #getProperty}. Unresolvable placeholders with
     * no default value are ignored and passed through unchanged.
     *
     * @param text the String to resolve
     * @return the resolved String (never {@code null})
     * @throws IllegalArgumentException if given text is {@code null}
     */
    String resolvePlaceholders(String text);

    /**
     * Resolve ${...} placeholders in the given text, replacing them with corresponding
     * property values as resolved by {@link #getProperty}. Unresolvable placeholders with
     * no default value will cause an {@link IllegalArgumentException} to be thrown.
     *
     * @param text the String to resolve
     * @return the resolved String (never {@code null})
     * @throws IllegalArgumentException if given text is {@code null}
     */
    String resolveRequiredPlaceholders(String text) throws IllegalArgumentException;

}
