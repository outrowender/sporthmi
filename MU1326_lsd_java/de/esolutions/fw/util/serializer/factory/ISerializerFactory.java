/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamDeserializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;

public interface ISerializerFactory {
    public IStreamSerializer createStreamSerializer();

    public IStreamDeserializer createStreamDeserializer();

    public ISerializer createExtendedSerializer();

    public IDeserializer createExtendedDeserializer();
}

