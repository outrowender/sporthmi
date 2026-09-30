/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ChangedArray
extends BAPArray {
    public void setArrayData(BAPArrayData var1);

    public BAPArrayData getArrayData();

    public BAPArrayElement createArrayElement();
}

