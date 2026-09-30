/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPIndicationHandlerPropertyFSG {
    public void processIndicationAck(BAPFunctionPropertyFSG var1, AckProperty var2);

    public void processIndicationSet(BAPFunctionPropertyFSG var1, SetGetProperty var2);

    public void processIndicationSetGet(BAPFunctionPropertyFSG var1, SetGetProperty var2);
}

