package com.koen.study.web.exception;

public class CommonException extends Exception {
    private final long errorId;

    public CommonException(String message, long errorId) {
        super(message);
        this.errorId = errorId;
    }

    public long getErrorId() {
        return errorId;
    }
}
