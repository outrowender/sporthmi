/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparatorWrapper;
import de.audi.atip.utils.generics.GSortedMapSerializable;
import de.audi.atip.utils.generics.GSortedMapWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GSortedMapSerializableWrapper<K extends Serializable, V extends Serializable>
extends GSortedMapWrapper<K, V>
implements GSortedMapSerializable<K, V> {
    private static final long serialVersionUID = 1L;

    protected GSortedMapSerializableWrapper() {
    }

    public GSortedMapSerializableWrapper(GComparatorWrapper<? super K> gComparatorWrapper) {
        super(gComparatorWrapper);
    }

    public GSortedMapSerializableWrapper(Map map) {
        super(map);
    }

    public GSortedMapSerializableWrapper(SortedMap sortedMap) {
        super(sortedMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.backingMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.backingMap = (Map)objectInputStream.readObject();
    }
}

