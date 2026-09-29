/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GMapWrapper
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GMapSerializable;
import de.audi.atip.utils.generics.GMapWrapper;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class GMapSerializableWrapper
extends GMapWrapper
implements GMapSerializable {
    private static final long serialVersionUID;

    public GMapSerializableWrapper(Map map) {
        super(map);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.backingMap);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.backingMap = (Map)objectInputStream.readObject();
    }
}

