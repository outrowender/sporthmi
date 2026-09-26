/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.logging;

import org.apache.commons.logging.Log;

public class DefaultLog
implements Log {
    @Override
    public void debug(Object object) {
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(Object object) {
    }

    @Override
    public void error(Object object) {
    }

    @Override
    public void info(Object object) {
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void error(Object object, Throwable throwable) {
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    @Override
    public void fatal(Object object, Throwable throwable) {
    }

    @Override
    public void warn(Object object, Throwable throwable) {
    }
}

