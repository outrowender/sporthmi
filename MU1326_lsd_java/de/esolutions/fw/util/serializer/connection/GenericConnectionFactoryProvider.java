/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.GenericConnectionFactory;
import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ITransportFactoryProvider;

public class GenericConnectionFactoryProvider
implements IConnectionFactoryProvider {
    protected ITransportFactoryProvider transportFactoryProvider;
    protected ISerializerFactoryProvider serializerFactoryProvider;

    public GenericConnectionFactoryProvider(ITransportFactoryProvider iTransportFactoryProvider, ISerializerFactoryProvider iSerializerFactoryProvider) {
        this.transportFactoryProvider = iTransportFactoryProvider;
        this.serializerFactoryProvider = iSerializerFactoryProvider;
    }

    public IConnectionFactory createConnectionFactory(String string, String string2) throws ConnectionFactoryException {
        try {
            ISingleTransportFactory iSingleTransportFactory = this.transportFactoryProvider.createSingleTransportFactory(string, string2);
            ISerializerFactory iSerializerFactory = this.serializerFactoryProvider.createSerializerFactory(string, string2);
            return new GenericConnectionFactory(iSingleTransportFactory, iSerializerFactory);
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException("Transport failed for peer " + string + ":" + string2 + " -> " + transportFactoryException.toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException("Serializer failed for peer " + string + ":" + string2 + " -> " + serializerFactoryException.toString());
        }
    }

    public ISpawnConnectionFactory createSpawnConnectionFactory(String string, String string2) throws ConnectionFactoryException {
        try {
            ISpawnTransportFactory iSpawnTransportFactory = this.transportFactoryProvider.createSpawnTransportFactory(string, string2);
            ISerializerFactory iSerializerFactory = this.serializerFactoryProvider.createMySerializerFactory(string, string2);
            return new GenericSpawnConnectionFactory(iSpawnTransportFactory, iSerializerFactory);
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException("Transport failed: " + transportFactoryException.toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException("Serializer failed: " + serializerFactoryException.toString());
        }
    }
}

