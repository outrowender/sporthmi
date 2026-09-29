/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.apache.xerces.util.AugmentationsImpl$SmallContainer;

class AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration
implements Enumeration {
    Object[] enumArray;
    int next;
    private final /* synthetic */ AugmentationsImpl$SmallContainer this$1;

    AugmentationsImpl$SmallContainer$SmallContainerKeyEnumeration(AugmentationsImpl$SmallContainer augmentationsImpl$SmallContainer) {
        this.this$1 = augmentationsImpl$SmallContainer;
        this.enumArray = new Object[this.this$1.fNumEntries];
        this.next = 0;
        for (int i2 = 0; i2 < augmentationsImpl$SmallContainer.fNumEntries; ++i2) {
            this.enumArray[i2] = augmentationsImpl$SmallContainer.fAugmentations[i2 * 2];
        }
    }

    @Override
    public boolean hasMoreElements() {
        return this.next < this.enumArray.length;
    }

    @Override
    public Object nextElement() {
        if (this.next >= this.enumArray.length) {
            throw new NoSuchElementException();
        }
        Object object = this.enumArray[this.next];
        this.enumArray[this.next] = null;
        ++this.next;
        return object;
    }
}

