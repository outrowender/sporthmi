/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;

public interface GetArray
extends BAPArray {
    public int getAsgId();

    public void setAsgId(int var1);

    public int getTransactionId();

    public void setTransactionId(int var1);
}

