/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;

public interface ITraceCommandExecutor {
    public void activateBackend(ITraceBackend var1);

    public void createEntity(int var1, TraceEntity var2, short var3);

    public void changeFilterLevel(int var1, TraceEntity var2, short var3);

    public void executeCallback(int var1, byte[] var2);

    public void requestFilterLevel(TraceEntityURI var1, short var2);

    public void connectBackend(short var1, boolean var2);

    public void disconnectBackend(short var1);

    public void registerBackend(ITraceBackend var1, TraceConfigBackend var2, String var3);

    public void unregisterBackend(ITraceBackend var1);

    public boolean flushMessages();

    public void flushEntities();

    public void requestQuit();

    public void quit();

    public void init();

    public void registerTimeZone(int var1, TraceTimeZone var2);

    public void updateTimeZone(TraceTimeZone var1);

    public void resizeBuffer(int var1);
}

