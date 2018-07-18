package org.myspring.beans;

import org.myspring.core.NestedRuntimeException;

public abstract class BeansException extends NestedRuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
