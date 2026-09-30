/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;

public interface IConnectionFactoryProvider {
    public IConnectionFactory createConnectionFactory(String var1, String var2) throws ConnectionFactoryException;

    public ISpawnConnectionFactory createSpawnConnectionFactory(String var1, String var2) throws ConnectionFactoryException;
}

