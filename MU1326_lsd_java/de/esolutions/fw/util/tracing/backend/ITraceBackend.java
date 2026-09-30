/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceBackend {
    public static final int FLAGS_DECODE_MESSAGE = 1;
    public static final int FLAGS_ACCEPT_BULK_LOG_DATA = 8;
    public static final int FLAGS_ACCEPT_BULK_CREATE_ENTITY = 16;
    public static final int FLAGS_ACCEPT_BULK_CHANGE_LEVEL = 32;

    public void init(short var1, ITraceBackendListener var2, TraceConfigBackend var3);

    public void exit();

    public String getName();

    public int getFlags();

    public boolean connect();

    public void disconnect();

    public short backendFilterLevel(ITraceEntity var1);

    public short backendDefaultFilterLevel(short var1);

    public boolean adjustToChangeLevel(ITraceEntity var1);

    public boolean createEntity(ITraceEntity var1);

    public boolean createEntityBulk(ITraceEntity[] var1);

    public boolean changeFilterLevel(TraceEntityURI var1, short var2);

    public boolean changeFilterLevelBulk(ITraceEntity[] var1);

    public boolean log(ITraceMessage var1);

    public ITraceMessage logBulk(ITraceMessage[] var1);

    public boolean droppedMessages(int var1);

    public void handleBreak();

    public boolean registerTimeZone(int var1, int var2, String var3);

    public boolean updateTimeZone(int var1, long var2, long var4);
}

