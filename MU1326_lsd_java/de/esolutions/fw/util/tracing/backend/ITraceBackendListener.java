/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;

public interface ITraceBackendListener {
    public void connected(short var1, boolean var2);

    public void disconnected(short var1);

    public boolean triggerRequestFilterLevel(TraceEntityURI var1, short var2);

    public boolean triggerExecuteCallback(int var1, byte[] var2);

    public short queryFilterLevel(TraceEntityURI var1);

    public void logMessage(short var1, String var2);

    public int getCoreMaxEntities();

    public String getCoreId();

    public void requestQuit();

    public ITraceMessageFormatter createFormatter(String var1, boolean var2);

    public ITraceEntityResolver getEntityResolver();

    public String getTimeZoneName(int var1);

    public Object getComponent(String var1);
}

