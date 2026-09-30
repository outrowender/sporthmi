/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;

public interface IBAPIndicationHandlerArrayFSG {
    public void processIndicationAckArray(BAPFunctionArrayFSG var1, BAPArray var2);

    public void processIndicationSetArray(BAPFunctionArrayFSG var1, SetGetArray var2);

    public void processIndicationSetGetArray(BAPFunctionArrayFSG var1, SetGetArray var2);

    public GetArrayIndication evaluateGetArrayIndication(int var1, GetArray var2);
}

