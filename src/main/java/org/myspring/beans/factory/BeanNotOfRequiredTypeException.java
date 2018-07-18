package org.myspring.beans.factory;

import org.myspring.beans.BeansException;

public class BeanNotOfRequiredTypeException extends BeansException {

    public BeanNotOfRequiredTypeException(String message) {
        super(message);
    }

    public BeanNotOfRequiredTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
