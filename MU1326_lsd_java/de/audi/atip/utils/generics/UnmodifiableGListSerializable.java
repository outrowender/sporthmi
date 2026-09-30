/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GListSerializable;
import de.audi.atip.utils.generics.UnmodifiableGList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UnmodifiableGListSerializable<T extends Serializable>
extends UnmodifiableGList<T>
implements GListSerializable<T> {
    private static final long serialVersionUID = 1L;

    public UnmodifiableGListSerializable(GListSerializable<T> gListSerializable) {
        super(gListSerializable);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.list);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.list = (GList)objectInputStream.readObject();
        this.initIterators(this.list);
    }
}

