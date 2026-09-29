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
    default public BAPFunctionMethodASG getBAPFunctionMethodASG(int n) {
    }

    default public StartResultMethod createStartResulForMethodASG(int n) {
    }

    default public AbortResultMethod createAbortResulForMethodASG(int n) {
    }

    default public BAPFunctionPropertyASG getBAPFunctionPropertyASG(int n) {
    }

    default public SetGetProperty createSetGetForPropertyASG(int n) {
    }

    default public AckProperty createAckForPropertyASG(int n) {
    }

    default public BAPFunctionArrayASG getBAPFunctionArrayASG(int n) {
    }

    default public GetArray createGetArrayForArrayASG(int n) {
    }

    default public SetGetArray createSetGetArrayForArrayASG(int n) {
    }

    default public SetGetArray createSetArrayForArrayASG(int n) {
    }
}

