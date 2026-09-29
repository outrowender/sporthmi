/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public interface IBAPArrayASGIND {
    default public void statusArrayIND(StatusArray statusArray) {
    }

    default public void changedArrayIND(ChangedArray changedArray) {
    }
}

