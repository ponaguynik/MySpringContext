package org.myspring.context;

import org.springframework.context.MessageSourceResolvable;

import javax.annotation.Nullable;
import java.util.Locale;

/**
 * Strategy interface for resolving messages, with support for the parameterization
 * and internationalization of such messages;.
 */
public interface MessageSource {

    @Nullable
    String getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale);

    String getMessage(String code, @Nullable Object[] args, Locale locale) throws NoSuchMessageException;

    String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException;
}
