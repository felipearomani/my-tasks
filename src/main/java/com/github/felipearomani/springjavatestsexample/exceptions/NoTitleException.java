package com.github.felipearomani.springjavatestsexample.exceptions;

public class NoTitleException extends RuntimeException {
    public NoTitleException(String message) {
        super(message);
    }

    public NoTitleException(String message, Throwable cause) {
        super(message, cause);
    }
}
