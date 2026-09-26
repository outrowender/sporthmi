/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import org.apache.xerces.util.AugmentationsImpl$AugmentationsItemsContainer;
import org.apache.xerces.util.AugmentationsImpl$SmallContainer;
import org.apache.xerces.xni.Augmentations;

public class AugmentationsImpl
implements Augmentations {
    private AugmentationsImpl$AugmentationsItemsContainer fAugmentationsContainer = new AugmentationsImpl$SmallContainer(this);

    @Override
    public Object putItem(String string, Object object) {
        Object object2 = this.fAugmentationsContainer.putItem(string, object);
        if (object2 == null && this.fAugmentationsContainer.isFull()) {
            this.fAugmentationsContainer = this.fAugmentationsContainer.expand();
        }
        return object2;
    }

    @Override
    public Object getItem(String string) {
        return this.fAugmentationsContainer.getItem(string);
    }

    @Override
    public Object removeItem(String string) {
        return this.fAugmentationsContainer.removeItem(string);
    }

    @Override
    public Enumeration keys() {
        return this.fAugmentationsContainer.keys();
    }

    @Override
    public void removeAllItems() {
        this.fAugmentationsContainer.clear();
    }

    public String toString() {
        return this.fAugmentationsContainer.toString();
    }
}

