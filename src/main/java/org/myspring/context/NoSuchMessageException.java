package org.myspring.context;

public class NoSuchMessageException extends RuntimeException{

    public NoSuchMessageException() {
    }

    public NoSuchMessageException(String message) {
        super(message);
    }

    public NoSuchMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchMessageException(Throwable cause) {
        super(cause);
    }
}
