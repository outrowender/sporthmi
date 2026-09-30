/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface StatusArray
extends BAPArray {
    public int getAsgId();

    public void setAsgId(int var1);

    public boolean isBroadcast();

    public void setBroadcast(boolean var1);

    public int getTransactionId();

    public void setTransactionId(int var1);

    public int getNumberOfElements();

    public void setNumberOfElements(int var1);

    public BAPArrayData getArrayData();

    public void setArrayData(BAPArrayData var1);

    public BAPArrayElement createArrayElement();
}

