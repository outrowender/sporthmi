/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;

public interface IBAPArrayASGREQ {
    public void getArrayREQ(GetArray var1);

    public void setGetArrayREQ(SetGetArray var1);

    public void setArrayREQ(SetGetArray var1);

    public void ackArrayREQ();
}

