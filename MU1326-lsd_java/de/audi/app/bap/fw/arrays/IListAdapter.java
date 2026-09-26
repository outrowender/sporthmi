/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public interface IListAdapter {
    default public IArrayHeader createArrayHeader() {
    }

    default public boolean sendFullRangeUpdate() {
    }

    default public boolean isSpontaneousStatusRequestSupported() {
    }

    default public void sendStatusRequest(GetArrayIndication getArrayIndication, CombiBAPArrayElement[] combiBAPArrayElementArray) {
    }

    default public void sendChangedArrayRequest(ListDelta listDelta) {
    }
}

