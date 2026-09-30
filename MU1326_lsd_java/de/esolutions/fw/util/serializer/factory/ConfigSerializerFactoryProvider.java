/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.serializer.factory.LEDefaultSerializerFactory;
import de.esolutions.fw.util.transport.config.SerializerParam;
import de.esolutions.fw.util.transport.config.TransportConfig;

public class ConfigSerializerFactoryProvider
implements ISerializerFactoryProvider {
    private TransportConfig config;

    public ConfigSerializerFactoryProvider(TransportConfig transportConfig) throws SerializerFactoryException {
        this.config = transportConfig;
        if (!transportConfig.isValid()) {
            throw new SerializerFactoryException("Can't create factory provider with inavlid config:\n" + transportConfig.getFailString());
        }
    }

    private ISerializerFactory fromQuery(IConfigQuery iConfigQuery, String string) throws SerializerFactoryException {
        SerializerParam serializerParam = SerializerParam.create(iConfigQuery);
        if (serializerParam == null) {
            throw new SerializerFactoryException("Invalid serializer for " + string);
        }
        int n = serializerParam.getType();
        if (n == 0) {
            return new BEDefaultSerializerFactory();
        }
        if (n == 1) {
            return new LEDefaultSerializerFactory();
        }
        throw new SerializerFactoryException("Unsupported serializer for " + string);
    }

    public ISerializerFactory createSerializerFactory(String string, String string2) throws SerializerFactoryException {
        String string3 = string + ":" + string2;
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new SerializerFactoryException("Can't find serializer for proc " + string3);
        }
        return this.fromQuery(configOverlayPathQuery, string3);
    }

    public ISerializerFactory createMySerializerFactory(String string, String string2) throws SerializerFactoryException {
        String string3 = string + ":" + string2;
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForMyService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new SerializerFactoryException("Can't find serializer for node " + string3);
        }
        return this.fromQuery(configOverlayPathQuery, string3);
    }
}

