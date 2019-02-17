package com.github.felipearomani.springjavatestsexample.exceptions;

public class DuplicatedTaskException extends Throwable {
    public DuplicatedTaskException(String message) {
        super(message);
    }
}
