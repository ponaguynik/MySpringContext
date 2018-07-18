package org.myspring.context;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * An {@link ApplicationEvent} that caries an arbitrary payload.
 */
public class PayloadApplicationEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
    private final T payload;

    public PayloadApplicationEvent(Object source, T payload) {
        super(source);
        this.payload = payload;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getPayload()));
    }

    public T getPayload() {
        return payload;
    }
}
