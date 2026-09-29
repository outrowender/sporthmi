/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.logging;

import org.apache.commons.logging.DefaultLog;
import org.apache.commons.logging.Log;

public class LogFactory {
    static final LogFactory factory = new LogFactory();
    static Log log = new DefaultLog();

    private LogFactory() {
    }

    public static Log getLog(Class clazz) {
        return log;
    }

    public static Log getLog(String string) {
        return log;
    }

    public static LogFactory getFactory() {
        return factory;
    }

    public void setAttribute(String string, String string2) {
    }

    public void setAttribute(String string, Object object) {
    }

    public void setLogger(Log log) {
        LogFactory.log = log;
    }
}

