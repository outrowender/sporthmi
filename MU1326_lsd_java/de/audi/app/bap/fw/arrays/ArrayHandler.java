/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.arrays.IListAdapter;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public interface ArrayHandler {
    public static final int INDEX_SIZE_8BIT = 0;
    public static final int INDEX_SIZE_16BIT = 1;

    public void addListAdapter(IListAdapter var1);

    public CombiBAPArrayElement getArrayElement(int var1);

    public void getNextListPos(int var1, int var2);

    public void getNextListPosResult(boolean var1, int var2, int var3, int var4);

    public int getCurrentListSize();

    public int getNumberOfElements();

    public int getPredecessorID(int var1);

    public int getSuccessorID(int var1);

    public int getIndexSize();

    public boolean is16BitIndexSize();

    public boolean dataMustBeReversed();

    public boolean sendFullRangeUpdate();

    public void requestListElements(GetArrayIndication var1);

    public void responseListElements(int var1, CombiBAPArrayElement[] var2);
}

