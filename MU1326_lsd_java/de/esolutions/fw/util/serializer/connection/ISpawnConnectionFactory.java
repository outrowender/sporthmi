/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import java.io.IOException;

public interface ISpawnConnectionFactory {
    public void setListener(ISpawnedConnectionListener var1);

    public void enableSpawning() throws IOException;

    public void disableSpawning();

    public String getDescription();
}

