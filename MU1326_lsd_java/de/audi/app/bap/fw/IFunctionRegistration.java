/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.fw.functiontypes.IBAPFunction;
import java.util.List;

public interface IFunctionRegistration {
    public IBAPFunction getBAPFunction(int var1);

    public List getAllProperties();

    public List getAllMethods();

    public List getAllArrays();

    public void resetBAPFunctions();
}

