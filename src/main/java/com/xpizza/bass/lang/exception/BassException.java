package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: BassExcetion
 * @Description: TODO 自定义异常基类
 * @author: Xpizza
 * @date: Jul 6, 2017 2:05:01 PM
 */
public abstract class BassException extends RuntimeException{

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -1198665829030943104L;

    public BassException() {
    }

    public BassException(String message) {
        super(message);
    }

    public BassException(String message, Throwable cause) {
        super(message, cause);
    }

    public BassException(Throwable cause) {
        super(cause);
    }

    public BassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
