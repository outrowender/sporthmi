/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.IFunctionRegistration;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusArray;
import de.vw.mib.bap.requests.StatusProperty;

public interface IFunctionRegistrationFSG
extends IFunctionRegistration {
    public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int var1);

    public ResultMethod createResultForMethodFSG(int var1);

    public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int var1);

    public StatusProperty createStatusForPropertyFSG(int var1);

    public StatusAckProperty createStatusAckForPropertyFSG(int var1);

    public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int var1);

    public StatusArray createStatusArrayForArrayFSG(int var1);

    public ChangedArray createChangedArrayForArrayFSG(int var1);
}

