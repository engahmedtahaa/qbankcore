package com.myfcit.qbank.core.logs;



public class QbankLoggerFactory {
    private static QbankLogger logger;
    
    static {
        logger = new QbankLogger(QbankLogger.class, "logs", "qbank-logs", "qbank-log");
        }
    
    public synchronized static QbankLogger getLogger(){
        return logger;
    }
}
