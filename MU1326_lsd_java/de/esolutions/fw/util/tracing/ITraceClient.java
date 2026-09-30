/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;

public interface ITraceClient {
    public boolean enableChannel(TraceChannel var1);

    public boolean disableChannel(TraceChannel var1);

    public boolean logMessage(TraceChannel var1, short var2, short var3, String var4, Object[] var5);

    public boolean logMessage(TraceChannel var1, short var2, short var3, short var4, byte[] var5);

    public boolean registerChannel(TraceChannel var1);

    public boolean unregisterChannel(TraceChannel var1);

    public boolean changeChannelFilterLevel(TraceChannel var1, short var2);
}

