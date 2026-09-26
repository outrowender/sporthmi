/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.util.AugmentationsImpl$AugmentationsItemsContainer;

class AugmentationsImpl$LargeContainer
extends AugmentationsImpl$AugmentationsItemsContainer {
    final Hashtable fAugmentations;
    private final /* synthetic */ AugmentationsImpl this$0;

    AugmentationsImpl$LargeContainer(AugmentationsImpl augmentationsImpl) {
        this.this$0 = augmentationsImpl;
        super(augmentationsImpl);
        this.fAugmentations = new Hashtable();
    }

    @Override
    public Object getItem(Object object) {
        return this.fAugmentations.get(object);
    }

    @Override
    public Object putItem(Object object, Object object2) {
        return this.fAugmentations.put(object, object2);
    }

    @Override
    public Object removeItem(Object object) {
        return this.fAugmentations.remove(object);
    }

    @Override
    public Enumeration keys() {
        return this.fAugmentations.keys();
    }

    @Override
    public void clear() {
        this.fAugmentations.clear();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public AugmentationsImpl$AugmentationsItemsContainer expand() {
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LargeContainer");
        Enumeration enumeration = this.fAugmentations.keys();
        while (enumeration.hasMoreElements()) {
            Object object = enumeration.nextElement();
            stringBuffer.append("\nkey == ");
            stringBuffer.append(object);
            stringBuffer.append("; value == ");
            stringBuffer.append(this.fAugmentations.get(object));
        }
        return stringBuffer.toString();
    }
}

