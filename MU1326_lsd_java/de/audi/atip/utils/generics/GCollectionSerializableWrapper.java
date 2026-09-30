/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.FluentCollection;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GCollectionSerializableWrapper<T extends Serializable>
extends GCollectionWrapper<T>
implements GCollectionSerializable<T> {
    private static final long serialVersionUID = 1L;

    public GCollectionSerializableWrapper(Collection collection) {
        super(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.backingCollection);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.backingCollection = (Collection)objectInputStream.readObject();
    }

    @Override
    public /* synthetic */ FluentCollection fluent() {
        return super.fluent();
    }

    @Override
    public /* synthetic */ Collection getBackingCollection() {
        return super.getBackingCollection();
    }

    @Override
    public /* synthetic */ String toString() {
        return super.toString();
    }

    @Override
    public /* synthetic */ boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override
    public /* synthetic */ Object[] toArray() {
        return super.toArray();
    }

    @Override
    public /* synthetic */ int size() {
        return super.size();
    }

    @Override
    public /* synthetic */ boolean retainAll(GCollection gCollection) {
        return super.retainAll(gCollection);
    }

    @Override
    public /* synthetic */ boolean removeAll(GCollection gCollection) {
        return super.removeAll(gCollection);
    }

    @Override
    public /* synthetic */ GIterator iterator() {
        return super.iterator();
    }

    @Override
    public /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public /* synthetic */ boolean containsAll(GCollection gCollection) {
        return super.containsAll(gCollection);
    }

    @Override
    public /* synthetic */ void clear() {
        super.clear();
    }

    @Override
    public /* synthetic */ boolean addAll(GCollection gCollection) {
        return super.addAll(gCollection);
    }
}

