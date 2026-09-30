/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.serializer.connection.Connection;

public interface IRemoteListenNotifier {
    public void connectedLogger(String var1, Connection var2);

    public void disconnectedLogger(String var1, Connection var2);
}

