/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public interface ArrayHandler {
    public static final int INDEX_SIZE_8BIT;
    public static final int INDEX_SIZE_16BIT;

    default public void addListAdapter(IListAdapter iListAdapter) {
    }

    default public CombiBAPArrayElement getArrayElement(int n) {
    }

    default public void getNextListPos(int n, int n2) {
    }

    default public void getNextListPosResult(boolean bl, int n, int n2, int n3) {
    }

    default public int getCurrentListSize() {
    }

    default public int getNumberOfElements() {
    }

    default public int getPredecessorID(int n) {
    }

    default public int getSuccessorID(int n) {
    }

    default public int getIndexSize() {
    }

    default public boolean is16BitIndexSize() {
    }

    default public boolean dataMustBeReversed() {
    }

    default public boolean sendFullRangeUpdate() {
    }

    default public void requestListElements(GetArrayIndication getArrayIndication) {
    }

    default public void responseListElements(int n, CombiBAPArrayElement[] combiBAPArrayElementArray) {
    }
}

