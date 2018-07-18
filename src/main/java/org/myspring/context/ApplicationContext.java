package org.myspring.context;

import org.myspring.beans.factory.HierarchicalBeanFactory;
import org.myspring.beans.factory.ListableBeanFactory;
import org.myspring.beans.factory.config.AutowireCapableBeanFactory;
import org.myspring.core.env.EnvironmentCapable;
import org.myspring.core.io.support.ResourcePatternResolver;

import javax.annotation.Nullable;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while application is running.
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
        MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

    /**
     * Return the unique id of this application context, or {@code null} if none
     */
    @Nullable
    String getId();

    /**
     * Return a name for the deployed application that this context belongs to, or the empty
     * String by default.
     */
    String getApplicationName();

    /**
     * Return a friendly name for this context (never {@code null}).
     */
    String getDisplayName();

    long getStartupDate();

    @Nullable
    ApplicationContext getParent();

    /**
     * Expose AutowireCapableBeanFactory functionality for this context.
     * <p>This is not typically used by application code, except for the purpose of
     * initializing bean instances that live outside of the application context,
     * applying the Spring bean lifecycle (fully or partly) to them.
     *
     * @return the AutowireCapableBeanFactory for this context
     * {@link AutowireCapableBeanFactory} interface, or does not hold an
     * autowire-capable bean factory yet (e.g. if {@code refresh()} has
     * never been called), or if the context has been closed already
     */
    AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
