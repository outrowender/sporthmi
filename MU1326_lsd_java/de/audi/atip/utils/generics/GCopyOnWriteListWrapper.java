/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.collections.CopyOnWriteArrayList;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GListWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class GCopyOnWriteListWrapper<T>
extends GListWrapper<T>
implements GCopyOnWriteList<T> {
    private final CopyOnWriteArrayList copyOnWriteArrayList;

    public GCopyOnWriteListWrapper(CopyOnWriteArrayList copyOnWriteArrayList) {
        super(copyOnWriteArrayList);
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    @Override
    public boolean addIfAbsent(T t) {
        return this.copyOnWriteArrayList.addIfAbsent(t);
    }
}

