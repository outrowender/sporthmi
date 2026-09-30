/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GMapSerializable;
import de.audi.atip.utils.generics.GMapWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GMapSerializableWrapper<K extends Serializable, V extends Serializable>
extends GMapWrapper<K, V>
implements GMapSerializable<K, V> {
    private static final long serialVersionUID = 1L;

    public GMapSerializableWrapper(Map map) {
        super(map);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.backingMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.backingMap = (Map)objectInputStream.readObject();
    }
}

