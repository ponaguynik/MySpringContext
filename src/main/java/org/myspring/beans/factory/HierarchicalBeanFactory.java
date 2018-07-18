package org.myspring.beans.factory;

import javax.annotation.Nullable;

/**
 * Sub-interface implemented by bean factories that can be part of a hierarchy.
 */
public interface HierarchicalBeanFactory extends BeanFactory {

    @Nullable
    BeanFactory getParentBeanFactory();

    boolean containsLocalBean(String name);
}
