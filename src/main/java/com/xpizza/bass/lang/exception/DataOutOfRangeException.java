package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: DataOutOfRangeException
 * @Description: TODO 数据超出范围异常
 * @author: Xpizza
 * @date: Jul 6, 2017 2:08:32 PM
 */
public class DataOutOfRangeException extends BassException {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -4887158859924245182L;

    public DataOutOfRangeException() {
        super("Data out of range");
    }

    public DataOutOfRangeException(String message) {
        super(message);
    }

    public DataOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataOutOfRangeException(Throwable cause) {
        super(cause);
    }

    public DataOutOfRangeException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
