package org.myspring.core.io;

import org.springframework.util.ResourceUtils;

import javax.annotation.Nullable;

/**
 * Strategy interface for loading resources.
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

    Resource getResource(String location);

    @Nullable
    ClassLoader getClassLoader();
}
