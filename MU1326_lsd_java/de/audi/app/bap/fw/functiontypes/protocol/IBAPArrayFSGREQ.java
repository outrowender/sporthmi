/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public interface IBAPArrayFSGREQ {
    public void statusArrayREQ(int var1, StatusArray var2);

    public void changedArrayREQ(ChangedArray var1);
}

