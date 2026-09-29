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
    default public BAPFunctionMethodFSG getBAPFunctionMethodFSG(int n) {
    }

    default public ResultMethod createResultForMethodFSG(int n) {
    }

    default public BAPFunctionPropertyFSG getBAPFunctionPropertyFSG(int n) {
    }

    default public StatusProperty createStatusForPropertyFSG(int n) {
    }

    default public StatusAckProperty createStatusAckForPropertyFSG(int n) {
    }

    default public BAPFunctionArrayFSG getBAPFunctionArrayFSG(int n) {
    }

    default public StatusArray createStatusArrayForArrayFSG(int n) {
    }

    default public ChangedArray createChangedArrayForArrayFSG(int n) {
    }
}

