/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.collections.CopyOnWriteMap;
import java.util.Iterator;

class CopyOnWriteMap$CopyOnWriteIterator
implements Iterator {
    private final Iterator realIterator;
    private final /* synthetic */ CopyOnWriteMap this$0;

    public CopyOnWriteMap$CopyOnWriteIterator(CopyOnWriteMap copyOnWriteMap, Iterator iterator) {
        this.this$0 = copyOnWriteMap;
        this.realIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.realIterator.hasNext();
    }

    @Override
    public Object next() {
        return this.realIterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }
}

