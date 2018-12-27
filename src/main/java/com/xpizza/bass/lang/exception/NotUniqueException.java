package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: NotUniqueException
 * @Description: TODO 非唯一性异常
 * @author: Xpizza
 * @date: Jul 6, 2017 2:09:32 PM
 */
public class NotUniqueException extends BassException {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -270146587443078787L;

    public NotUniqueException() {
        super("Not unique exception");
    }

    public NotUniqueException(String message) {
        super(message);
    }

    public NotUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniqueException(Throwable cause) {
        super(cause);
    }

    public NotUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
