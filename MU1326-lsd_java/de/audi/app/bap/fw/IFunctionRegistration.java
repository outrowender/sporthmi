/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import java.util.List;

public interface IFunctionRegistration {
    default public IBAPFunction getBAPFunction(int n) {
    }

    default public List getAllProperties() {
    }

    default public List getAllMethods() {
    }

    default public List getAllArrays() {
    }

    default public void resetBAPFunctions() {
    }
}

