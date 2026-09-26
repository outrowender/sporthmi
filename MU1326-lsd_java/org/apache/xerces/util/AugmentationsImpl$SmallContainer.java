/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.util.AugmentationsImpl$AugmentationsItemsContainer;
import org.apache.xerces.util.AugmentationsImpl$LargeContainer;
import org.apache.xerces.util.AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration;

class AugmentationsImpl$SmallContainer
extends AugmentationsImpl$AugmentationsItemsContainer {
    static final int SIZE_LIMIT;
    final Object[] fAugmentations;
    int fNumEntries;
    private final /* synthetic */ AugmentationsImpl this$0;

    AugmentationsImpl$SmallContainer(AugmentationsImpl augmentationsImpl) {
        this.this$0 = augmentationsImpl;
        super(augmentationsImpl);
        this.fAugmentations = new Object[20];
        this.fNumEntries = 0;
    }

    @Override
    public Enumeration keys() {
        return new AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration(this);
    }

    @Override
    public Object getItem(Object object) {
        for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
            if (!this.fAugmentations[i2].equals(object)) continue;
            return this.fAugmentations[i2 + 1];
        }
        return null;
    }

    @Override
    public Object putItem(Object object, Object object2) {
        for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
            if (!this.fAugmentations[i2].equals(object)) continue;
            Object object3 = this.fAugmentations[i2 + 1];
            this.fAugmentations[i2 + 1] = object2;
            return object3;
        }
        this.fAugmentations[this.fNumEntries * 2] = object;
        this.fAugmentations[this.fNumEntries * 2 + 1] = object2;
        ++this.fNumEntries;
        return null;
    }

    @Override
    public Object removeItem(Object object) {
        for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
            if (!this.fAugmentations[i2].equals(object)) continue;
            Object object2 = this.fAugmentations[i2 + 1];
            for (int i3 = i2; i3 < this.fNumEntries * 2 - 2; i3 += 2) {
                this.fAugmentations[i3] = this.fAugmentations[i3 + 2];
                this.fAugmentations[i3 + 1] = this.fAugmentations[i3 + 3];
            }
            this.fAugmentations[this.fNumEntries * 2 - 2] = null;
            this.fAugmentations[this.fNumEntries * 2 - 1] = null;
            --this.fNumEntries;
            return object2;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
            this.fAugmentations[i2] = null;
            this.fAugmentations[i2 + 1] = null;
        }
        this.fNumEntries = 0;
    }

    @Override
    public boolean isFull() {
        return this.fNumEntries == 10;
    }

    @Override
    public AugmentationsImpl$AugmentationsItemsContainer expand() {
        AugmentationsImpl$LargeContainer augmentationsImpl$LargeContainer = new AugmentationsImpl$LargeContainer(this.this$0);
        for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
            augmentationsImpl$LargeContainer.putItem(this.fAugmentations[i2], this.fAugmentations[i2 + 1]);
        }
        return augmentationsImpl$LargeContainer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SmallContainer - fNumEntries == ").append(this.fNumEntries);
        for (int i2 = 0; i2 < 20; i2 += 2) {
            stringBuffer.append("\nfAugmentations[");
            stringBuffer.append(i2);
            stringBuffer.append("] == ");
            stringBuffer.append(this.fAugmentations[i2]);
            stringBuffer.append("; fAugmentations[");
            stringBuffer.append(i2 + 1);
            stringBuffer.append("] == ");
            stringBuffer.append(this.fAugmentations[i2 + 1]);
        }
        return stringBuffer.toString();
    }
}

