package com.koen.study.web.exception;

public class AccessException extends Exception{
    public AccessException() {
        super("Нет прав доступа");
    }
}
