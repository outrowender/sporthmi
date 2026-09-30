/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GListSerializable;
import de.audi.atip.utils.generics.GListWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GListSerializableWrapper<T extends Serializable>
extends GListWrapper<T>
implements GListSerializable<T>,
GCollectionSerializable<T> {
    private static final long serialVersionUID = 1L;

    public GListSerializableWrapper(List list) {
        super(list);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.list);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.list = (List)objectInputStream.readObject();
    }
}

