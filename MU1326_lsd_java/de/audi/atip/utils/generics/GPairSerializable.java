/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GPair;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GPairSerializable<F extends Serializable, S extends Serializable>
extends GPair<F, S>
implements Serializable {
    private static final long serialVersionUID = 1L;

    public GPairSerializable(F f2, S s) {
        super(f2, s);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(new Object[]{this.first, this.second});
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objectArray = (Object[])objectInputStream.readObject();
        this.first = (Serializable)objectArray[0];
        this.second = (Serializable)objectArray[1];
    }
}

