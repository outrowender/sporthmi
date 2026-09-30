/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GSetSerializable;
import de.audi.atip.utils.generics.GSetWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GSetSerializableWrapper<T extends Serializable>
extends GSetWrapper<T>
implements GSetSerializable<T>,
GCollectionSerializable<T> {
    private static final long serialVersionUID = 1L;

    public GSetSerializableWrapper(Set set) {
        super(set);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.backingSet);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.backingSet = (Set)objectInputStream.readObject();
    }
}

