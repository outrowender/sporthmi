/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public interface IBAPArrayFSGREQ {
    default public void statusArrayREQ(int n, StatusArray statusArray) {
    }

    default public void changedArrayREQ(ChangedArray changedArray) {
    }
}

