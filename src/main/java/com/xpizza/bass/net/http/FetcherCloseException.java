package com.xpizza.bass.net.http;

import com.xpizza.bass.lang.exception.BassException;

/**
 * 抓取器关闭异常
 */
public class FetcherCloseException extends BassException {

    public FetcherCloseException() {
        super("Fetcher close exception");
    }

    public FetcherCloseException(String message) {
        super(message);
    }

    public FetcherCloseException(String message, Throwable cause) {
        super(message, cause);
    }

    public FetcherCloseException(Throwable cause) {
        super(cause);
    }

    public FetcherCloseException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
