/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklistSlot;

public interface IPicklistElement {
    public static final int GG_INDEX_NONE;

    default public IPicklistSlot[] getSlots() {
    }

    default public int getGraphGroupSize() {
    }

    default public int getGraphGroupIndex() {
    }

    default public int getGraphGroupId() {
    }

    default public int getRuleID() {
    }

    default public int getConfidence() {
    }

    default public long getObjectID() {
    }

    default public void setSlots(IPicklistSlot[] iPicklistSlotArray) {
    }
}

