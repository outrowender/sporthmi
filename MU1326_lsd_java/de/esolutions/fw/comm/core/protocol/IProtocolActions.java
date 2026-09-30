/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.protocol;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.serializer.IDeserializer;

public interface IProtocolActions {
    public void handleCreateStub(short var1, short var2, ServiceInstanceID var3);

    public void handleCreateRRStub(short var1, short var2, ServiceInstanceID var3, ServiceInstanceID var4, short var5);

    public void handleStubCreated(short var1, short var2);

    public void handleStubFailed(short var1, byte var2);

    public void handleDestroyStub(short var1);

    public void handleProxyAlive(short var1);

    public void handleCallMethod(short var1, short var2, IDeserializer var3);

    public void handleRRStubCreated(short var1, short var2, short var3);

    public void handlePing();
}

