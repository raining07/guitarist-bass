package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: EmptyDataException
 * @Description: TODO 空数据异常
 * @author: Xpizza
 * @date: Jul 6, 2017 2:08:44 PM
 */
public class EmptyDataException extends BassException {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -6937053194776261704L;

    public EmptyDataException() {
        super("Empty data exception");
    }

    public EmptyDataException(String message) {
        super(message);
    }

    public EmptyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDataException(Throwable cause) {
        super(cause);
    }

    public EmptyDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
