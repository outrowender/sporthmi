/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;

public interface ITransportFactoryProvider {
    public ISingleTransportFactory createSingleTransportFactory(String var1, String var2) throws TransportFactoryException;

    public ISpawnTransportFactory createSpawnTransportFactory(String var1, String var2) throws TransportFactoryException;
}

