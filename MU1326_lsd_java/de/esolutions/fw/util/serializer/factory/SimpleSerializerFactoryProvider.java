/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.serializer.factory.LEDefaultSerializerFactory;
import java.util.HashMap;
import java.util.Map;

public class SimpleSerializerFactoryProvider
implements ISerializerFactoryProvider {
    protected Map procMap;
    protected Map nodeMap;
    protected String myProcName;

    public SimpleSerializerFactoryProvider(String string) {
        this.myProcName = string;
        this.procMap = new HashMap();
        this.nodeMap = new HashMap();
    }

    public void addConnection(String string, String string2, String string3, boolean bl) {
        Boolean bl2 = new Boolean(bl);
        this.procMap.put(string + ":" + string2, bl2);
        this.nodeMap.put(string + ":" + string3 + ":" + string2, bl2);
    }

    public ISerializerFactory createSerializerFactory(String string, String string2) throws SerializerFactoryException {
        String string3 = string + ":" + string2;
        Boolean bl = (Boolean)this.procMap.get(string3);
        if (bl == null) {
            throw new SerializerFactoryException("no serializer found for proc " + string3);
        }
        if (bl.booleanValue()) {
            return new LEDefaultSerializerFactory();
        }
        return new BEDefaultSerializerFactory();
    }

    public ISerializerFactory createMySerializerFactory(String string, String string2) throws SerializerFactoryException {
        String string3 = string + ":" + string2 + ":" + this.myProcName;
        Boolean bl = (Boolean)this.nodeMap.get(string3);
        if (bl == null) {
            throw new SerializerFactoryException("no serializer found for node " + string3);
        }
        if (bl.booleanValue()) {
            return new LEDefaultSerializerFactory();
        }
        return new BEDefaultSerializerFactory();
    }
}

