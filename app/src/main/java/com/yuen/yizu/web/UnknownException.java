package com.yuen.yizu.web;

/**
 * Created by zhoushun on 16/5/11.
 */
public class UnknownException extends RestException {

    public UnknownException() {
    }

    public UnknownException(String detailMessage) {
        super(detailMessage);
    }

    public UnknownException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public UnknownException(Throwable throwable) {
        super(throwable);
    }
}
