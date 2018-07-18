package org.myspring.core.io.support;

import org.myspring.core.io.Resource;
import org.myspring.core.io.ResourceLoader;

import java.io.IOException;

/**
 * Strategy interface for resolving a location pattern (for example,
 * an Ant-style path pattern) into Resource objects.
 */
public interface ResourcePatternResolver extends ResourceLoader {
    /**
     * Pseudo URL prefix for all matching resources from the class path: "classpath*:"
     * This differs from ResourceLoader's classpath URL prefix in that it
     * retrieves all matching resources for a given name (e.g. "/beans.xml"),
     * for example in the root of all deployed JAR files.
     *
     * @see org.springframework.core.io.ResourceLoader#CLASSPATH_URL_PREFIX
     */
    String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

    Resource[] getResources(String locationPattern) throws IOException;
}
