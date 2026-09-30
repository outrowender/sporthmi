/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.audi.app.bap.fw.arrays.ListDelta;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public interface IListAdapter {
    public IArrayHeader createArrayHeader();

    public boolean sendFullRangeUpdate();

    public boolean isSpontaneousStatusRequestSupported();

    public void sendStatusRequest(GetArrayIndication var1, CombiBAPArrayElement[] var2);

    public void sendChangedArrayRequest(ListDelta var1);
}

