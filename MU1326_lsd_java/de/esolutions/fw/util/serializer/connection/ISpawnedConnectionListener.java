/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import java.io.IOException;

public interface ISpawnedConnectionListener {
    public void spawnedConnection(Connection var1);

    public boolean spawningRetry(ISpawnConnectionFactory var1, IOException var2, int var3);

    public void spawningEnabled(ISpawnConnectionFactory var1);

    public void spawningDisabled(ISpawnConnectionFactory var1);
}

