/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.logging;

public interface Log {
    public void debug(Object var1);

    public boolean isWarnEnabled();

    public void warn(Object var1);

    public void error(Object var1);

    public void info(Object var1);

    public boolean isDebugEnabled();

    public void error(Object var1, Throwable var2);

    public boolean isErrorEnabled();

    public boolean isInfoEnabled();

    public boolean isFatalEnabled();

    public void fatal(Object var1, Throwable var2);

    public void warn(Object var1, Throwable var2);
}

