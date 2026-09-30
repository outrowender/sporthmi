/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.IFunctionRegistration;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IFunctionRegistrationASG
extends IFunctionRegistration {
    public BAPFunctionMethodASG getBAPFunctionMethodASG(int var1);

    public StartResultMethod createStartResulForMethodASG(int var1);

    public AbortResultMethod createAbortResulForMethodASG(int var1);

    public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int var1);

    public SetGetProperty createSetGetForPropertyASG(int var1);

    public AckProperty createAckForPropertyASG(int var1);

    public BAPFunctionArrayASG getBAPFunctionArrayASG(int var1);

    public GetArray createGetArrayForArrayASG(int var1);

    public SetGetArray createSetGetArrayForArrayASG(int var1);

    public SetGetArray createSetArrayForArrayASG(int var1);
}

