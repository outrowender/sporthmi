/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GListSerializable;
import de.audi.atip.utils.generics.GListWrapper;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GListSerializableWrapper
extends GListWrapper
implements GListSerializable,
GCollectionSerializable {
    private static final long serialVersionUID;

    public GListSerializableWrapper(List list) {
        super(list);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.list);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.list = (List)objectInputStream.readObject();
    }
}

