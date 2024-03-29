package com.example.app4.utils.exceptions;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
public class NoRollbackException extends RuntimeException {

    private final Object value;


    public NoRollbackException(Object value) {
        super();
        this.value = value;
    }

    public NoRollbackException(Object value,Throwable cause) {
        super(cause);
        this.value = value;
    }

    public NoRollbackException(String message, Object value) {
        super(message);
        this.value = value;
    }

    public NoRollbackException(Object value, String message) {
        super(message);
        this.value = value;
    }
    public NoRollbackException(Object value, String message, Throwable cause) {
        super(message,cause);
        this.value = value;
    }

}
