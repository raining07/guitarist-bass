package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: NotAuthorizedException
 * @Description: TODO 未被授权异常
 * @author: Xpizza
 * @date: Jul 6, 2017 2:09:02 PM
 */
public class NotAuthorizedException extends BassException {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 2868737074993141436L;

    public NotAuthorizedException() {
        super("Not Authorized exception");
    }

    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAuthorizedException(Throwable cause) {
        super(cause);
    }

    public NotAuthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
