package com.myfcit.qbank.core.exceptions;

public class QbankException extends Exception {
    @SuppressWarnings("compatibility:-9076262964973415530")
    private static final long serialVersionUID = 1L;

    protected String code;
    protected String message;

    public QbankException(String code, String message, Throwable thr) {
        super(thr);
        this.message = message;
        this.code = code;
    }

    public QbankException(String code, String message) {

        this.message = message;
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
