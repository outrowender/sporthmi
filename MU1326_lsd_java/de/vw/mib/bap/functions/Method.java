/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.MethodListener;

public interface Method
extends BAPFunction {
    public void startResult(BAPEntity var1, MethodListener var2);

    public void abortResult(BAPEntity var1, MethodListener var2);
}

