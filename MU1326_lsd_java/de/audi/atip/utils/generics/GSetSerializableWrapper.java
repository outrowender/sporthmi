/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GSetWrapper
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GSetSerializable;
import de.audi.atip.utils.generics.GSetWrapper;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public class GSetSerializableWrapper
extends GSetWrapper
implements GSetSerializable,
GCollectionSerializable {
    private static final long serialVersionUID;

    public GSetSerializableWrapper(Set set) {
        super(set);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.backingSet);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.backingSet = (Set)objectInputStream.readObject();
    }
}

