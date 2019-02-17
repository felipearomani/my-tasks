package com.github.felipearomani.springjavatestsexample.exceptions;

public class DuplicatedTaskException extends RuntimeException {
    public DuplicatedTaskException(String message) {
        super(message);
    }
}
