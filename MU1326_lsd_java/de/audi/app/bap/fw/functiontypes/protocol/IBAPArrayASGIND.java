/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public interface IBAPArrayASGIND {
    public void statusArrayIND(StatusArray var1);

    public void changedArrayIND(ChangedArray var1);
}

