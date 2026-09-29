/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import org.apache.xerces.util.AugmentationsImpl;

abstract class AugmentationsImpl$AugmentationsItemsContainer {
    private final /* synthetic */ AugmentationsImpl this$0;

    AugmentationsImpl$AugmentationsItemsContainer(AugmentationsImpl augmentationsImpl) {
        this.this$0 = augmentationsImpl;
    }

    public abstract Object putItem(Object object, Object object2) {
    }

    public abstract Object getItem(Object object) {
    }

    public abstract Object removeItem(Object object) {
    }

    public abstract Enumeration keys() {
    }

    public abstract void clear() {
    }

    public abstract boolean isFull() {
    }

    public abstract AugmentationsImpl$AugmentationsItemsContainer expand() {
    }
}

