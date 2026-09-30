/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import java.io.IOException;

public interface ISpawnedTransportListener {
    public void spawnedTransport(ITransport var1);

    public boolean spawningRetry(ISpawnTransportFactory var1, IOException var2, int var3);

    public void spawningEnabled(ISpawnTransportFactory var1);

    public void spawningDisabled(ISpawnTransportFactory var1);
}

