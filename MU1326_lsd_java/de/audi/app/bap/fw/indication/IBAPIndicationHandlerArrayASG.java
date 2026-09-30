/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public interface IBAPIndicationHandlerArrayASG {
    public void processIndicationChangedArray(BAPFunctionArrayASG var1, ChangedArray var2);

    public void processIndicationStatusArray(BAPFunctionArrayASG var1, StatusArray var2);

    public void processIndicationStatusArrayAck(BAPFunctionArrayASG var1, StatusArray var2);
}

