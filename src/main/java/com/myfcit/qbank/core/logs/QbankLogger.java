package com.myfcit.qbank.core.logs;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class QbankLogger {
    public QbankLogger() {
        super();
    }
    private Logger log4jLogger;

    public QbankLogger(Class clazz, String module, String subSystem, String logFileName) {
        File logsFolder =
            new File(System.getProperty("user.dir") + File.separator + module + File.separator + subSystem);
        logsFolder.mkdirs();

        String logFilePath = logsFolder.getAbsolutePath() + File.separator + logFileName + ".log";
        DailyRollingFileAppender drfa;

        try {
            drfa =
    new DailyRollingFileAppender(new PatternLayout("%d{MMM dd, yyyy HH:mm:ss,SSS} %-5p [" + clazz.getName() +
                                               "] %C %M (%t) %m%n"), logFilePath, "'.'yyyy-MMM-dd");
            log4jLogger = Logger.getLogger(clazz);
            log4jLogger.setLevel(Level.ALL);
            log4jLogger.addAppender(drfa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(Level level, Object obj) {
        try {
            log4jLogger.getClass().getMethod(level.toString().toLowerCase(), Object.class).invoke(log4jLogger, obj);
        } catch (NoSuchMethodException nsme) {
            nsme.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InvocationTargetException ite) {
            ite.printStackTrace();
        }
    }

    public void log(Level level, Object obj, Throwable thr) {
        try {
            log4jLogger.getClass().getMethod(level.toString().toLowerCase(), Object.class,
                                             Throwable.class).invoke(log4jLogger, obj, thr);
        } catch (NoSuchMethodException nsme) {
            nsme.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InvocationTargetException ite) {
            ite.printStackTrace();
        }
    }
}
