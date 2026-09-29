/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.concurrent;

import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import java.util.ListIterator;

class CopyOnWriteArrayList$CopyOnWriteListIterator
implements ListIterator {
    private final ListIterator realListIterator;
    private final /* synthetic */ CopyOnWriteArrayList this$0;

    public CopyOnWriteArrayList$CopyOnWriteListIterator(CopyOnWriteArrayList copyOnWriteArrayList, ListIterator listIterator) {
        this.this$0 = copyOnWriteArrayList;
        this.realListIterator = listIterator;
    }

    @Override
    public void add(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean hasNext() {
        return this.realListIterator.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return this.realListIterator.hasPrevious();
    }

    @Override
    public Object next() {
        return this.realListIterator.next();
    }

    @Override
    public int nextIndex() {
        return this.realListIterator.nextIndex();
    }

    @Override
    public Object previous() {
        return this.realListIterator.previous();
    }

    @Override
    public int previousIndex() {
        return this.realListIterator.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public void set(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }
}

