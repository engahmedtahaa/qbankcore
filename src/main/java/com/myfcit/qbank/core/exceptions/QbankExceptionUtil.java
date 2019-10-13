package com.myfcit.qbank.core.exceptions;



public class QbankExceptionUtil {
    public QbankExceptionUtil() {
        super();
    }
    public final static String GENERAL_EXCEPTION = "101";
    public final static String DAO_EXCEPTION="102";
    public final static String CLIENT_PROTOCOL_EXCEPTION="103";
    public final static String IO_EXCEPTION="104";
    public final static String IILEGAL_STATE_EXCEPTION="105";
    public final static String OPEN_TRANSACTION_MSG_EX="Error During Opening Transaction";
    public final static String DAO_MSG_EX="Error While Exceutiing Query";


    public static final QbankException wrap(Throwable thr) {
            return new QbankException(QbankExceptionUtil.GENERAL_EXCEPTION, thr.getMessage(), thr);
    }
}
