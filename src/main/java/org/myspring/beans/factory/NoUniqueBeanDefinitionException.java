package org.myspring.beans.factory;

public class NoUniqueBeanDefinitionException extends NoSuchBeanDefinitionException {

    public NoUniqueBeanDefinitionException(String message) {
        super(message);
    }

    public NoUniqueBeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }
}
