/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import java.io.IOException;

public class GenericSpawnConnectionFactory
implements ISpawnConnectionFactory {
    protected ISpawnTransportFactory transportFactory;
    protected TransportListenerAdapter adapter;

    public GenericSpawnConnectionFactory(ISpawnTransportFactory iSpawnTransportFactory, ISerializerFactory iSerializerFactory) {
        this.transportFactory = iSpawnTransportFactory;
        this.adapter = new TransportListenerAdapter(iSerializerFactory);
        iSpawnTransportFactory.setListener(this.adapter);
    }

    public void enableSpawning() throws IOException {
        this.transportFactory.enableSpawning();
    }

    public void disableSpawning() {
        this.transportFactory.disableSpawning();
    }

    public void setListener(ISpawnedConnectionListener iSpawnedConnectionListener) {
        this.adapter.setListener(iSpawnedConnectionListener);
    }

    public String getDescription() {
        return this.transportFactory.getDescription();
    }

    protected class TransportListenerAdapter
    implements ISpawnedTransportListener {
        protected ISerializerFactory serializerFactory;
        protected ISpawnedConnectionListener connectionListener;

        public TransportListenerAdapter(ISerializerFactory iSerializerFactory) {
            this.serializerFactory = iSerializerFactory;
        }

        public void setListener(ISpawnedConnectionListener iSpawnedConnectionListener) {
            this.connectionListener = iSpawnedConnectionListener;
        }

        public void spawnedTransport(ITransport iTransport) {
            ISerializer iSerializer = this.serializerFactory.createExtendedSerializer();
            IDeserializer iDeserializer = this.serializerFactory.createExtendedDeserializer();
            Connection connection = new Connection(iTransport, iSerializer, iDeserializer);
            if (this.connectionListener != null) {
                this.connectionListener.spawnedConnection(connection);
            }
        }

        public boolean spawningRetry(ISpawnTransportFactory iSpawnTransportFactory, IOException iOException, int n) {
            if (this.connectionListener != null) {
                return this.connectionListener.spawningRetry(GenericSpawnConnectionFactory.this, iOException, n);
            }
            return true;
        }

        public void spawningEnabled(ISpawnTransportFactory iSpawnTransportFactory) {
            if (this.connectionListener != null) {
                this.connectionListener.spawningEnabled(GenericSpawnConnectionFactory.this);
            }
        }

        public void spawningDisabled(ISpawnTransportFactory iSpawnTransportFactory) {
            if (this.connectionListener != null) {
                this.connectionListener.spawningDisabled(GenericSpawnConnectionFactory.this);
            }
        }
    }
}

