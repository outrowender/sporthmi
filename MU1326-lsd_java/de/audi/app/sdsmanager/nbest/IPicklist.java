/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;

public interface IPicklist {
    public static final int DUMMY_RULE_ID;

    default public IPicklistElement get(int n) {
    }

    default public int getPositionForSlotIndex(int n) {
    }

    default public int getSize() {
    }

    default public IPicklistSlot getSlot(int n, int n2) {
    }

    default public IPicklistElement[] getElements() {
    }

    default public int getLastRecogLineNumber() {
    }

    default public void setLastRecogLine(boolean bl, int n) {
    }

    default public boolean isLineSelectedByNumber() {
    }

    default public int[] getGraphGroupSizes() {
    }

    default public int[] getGraphGroupIndexes() {
    }

    default public IPicklist getRearrangedPicklist(int[] nArray) {
    }
}

