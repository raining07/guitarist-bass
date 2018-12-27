package com.xpizza.bass.net.http;

import com.xpizza.bass.lang.exception.BassException;

/**
 * 抓取器发送请求异常
 */
public class FetcherSendRequestException extends BassException {

    public FetcherSendRequestException() {
        super("Fetcher send request exception");
    }

    public FetcherSendRequestException(String message) {
        super(message);
    }

    public FetcherSendRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FetcherSendRequestException(Throwable cause) {
        super(cause);
    }

    public FetcherSendRequestException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
