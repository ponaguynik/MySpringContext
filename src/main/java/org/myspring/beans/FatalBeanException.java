package org.myspring.beans;

public class FatalBeanException extends BeansException {

    public FatalBeanException(String message) {
        super(message);
    }

    public FatalBeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
