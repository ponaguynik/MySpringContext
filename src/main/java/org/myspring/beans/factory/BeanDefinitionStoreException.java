package org.myspring.beans.factory;

import org.myspring.beans.FatalBeanException;

public class BeanDefinitionStoreException extends FatalBeanException {

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
