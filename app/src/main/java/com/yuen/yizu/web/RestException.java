package com.yuen.yizu.web;

/**
 * Created by zhoushun on 16/5/11.
 */
public class RestException extends RuntimeException {

    public RestException() {
    }

    public RestException(String detailMessage) {
        super(detailMessage);
    }

    public RestException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public RestException(Throwable throwable) {
        super(throwable);
    }
}
