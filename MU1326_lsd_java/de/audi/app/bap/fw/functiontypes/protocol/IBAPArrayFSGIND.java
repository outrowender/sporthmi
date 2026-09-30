/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;

public interface IBAPArrayFSGIND {
    public void setGetArrayIND(SetGetArray var1);

    public void setArrayIND(SetGetArray var1);

    public void getArrayIND(GetArray var1);

    public void ackArrayIND();

    public void ackArrayIND(BAPArray var1);
}

