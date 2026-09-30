/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.requests.GetArray;

public interface SetGetArray
extends GetArray {
    public BAPArrayData getArrayData();

    public void setArrayData(BAPArrayData var1);

    public BAPArrayElement createArrayElement();
}

