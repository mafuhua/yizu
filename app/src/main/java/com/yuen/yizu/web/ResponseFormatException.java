package com.yuen.yizu.web;

/**
 * Created by zhoushun on 16/5/11.
 */
public class ResponseFormatException extends RestException {

    public ResponseFormatException() {
    }

    public ResponseFormatException(String detailMessage) {
        super(detailMessage);
    }

    public ResponseFormatException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ResponseFormatException(Throwable throwable) {
        super(throwable);
    }
}
