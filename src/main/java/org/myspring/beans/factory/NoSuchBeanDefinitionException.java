package org.myspring.beans.factory;

import org.myspring.beans.BeansException;

public class NoSuchBeanDefinitionException extends BeansException {

    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }

    public NoSuchBeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }
}
