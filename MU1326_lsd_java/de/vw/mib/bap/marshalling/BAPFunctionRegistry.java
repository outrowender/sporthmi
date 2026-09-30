/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;

public interface BAPFunctionRegistry {
    public BAPFunction getBAPFunction(int var1);

    public Array getArray(int var1);

    public Method getMethod(int var1);

    public Property getProperty(int var1);

    public FSGOperationState getBapFSGOperationStateFunction();
}

