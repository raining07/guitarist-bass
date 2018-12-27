package com.xpizza.bass.lang.exception;

/**
 *
 * @ClassName: TypeCastException
 * @Description: TODO 类型转换异常
 * @author: Xpizza
 * @date: Jul 6, 2017 2:10:47 PM
 */
public class TypeCastException extends BassException {

    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -5929259682172526533L;

    public TypeCastException() {
        super("Type cast exception");
    }

    public TypeCastException(String message) {
        super(message);
    }

    public TypeCastException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeCastException(Throwable cause) {
        super(cause);
    }

    public TypeCastException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
