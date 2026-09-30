/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol;

import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface IProtocolActions {
    public boolean handleInit(String var1, int var2);

    public boolean handlePassiveInit();

    public void handleExit();

    public boolean handleCreateEntity(IExternalTraceEntity var1);

    public boolean handleLogData(ITraceMessage var1);

    public boolean handleChangeLevel(TraceEntityURI var1, short var2);

    public boolean handleExecuteCallback(int var1, byte[] var2);

    public boolean handleDroppedData(int var1);

    public boolean handleToggleEntity(TraceEntityURI var1, boolean var2);

    public boolean handleRegisterTimezone(int var1, int var2, String var3);

    public boolean handleUpdateTimezone(int var1, long var2, long var4);

    public boolean handleFileRequestMessage(int var1, String var2, byte var3);

    public boolean handleFileStatusMessage(int var1, String var2, byte var3, long var4, long var6, byte var8, byte[] var9);

    public boolean handleFileTransferMessage(int var1, int var2, byte var3, int var4, byte[] var5);
}

