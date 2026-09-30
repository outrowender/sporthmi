/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;

public interface ISerializerFactoryProvider {
    public ISerializerFactory createSerializerFactory(String var1, String var2) throws SerializerFactoryException;

    public ISerializerFactory createMySerializerFactory(String var1, String var2) throws SerializerFactoryException;
}

