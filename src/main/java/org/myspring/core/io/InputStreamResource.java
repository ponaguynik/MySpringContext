package org.myspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Simple interface for objects that are sources for an {@link InputStream}
 */
public interface InputStreamResource {

    InputStream getInputStream() throws IOException;
}
