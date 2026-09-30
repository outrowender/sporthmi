/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import java.io.IOException;

public interface ISpawnTransportFactory {
    public void setListener(ISpawnedTransportListener var1);

    public void enableSpawning() throws IOException;

    public void disableSpawning();

    public String getDescription();
}

