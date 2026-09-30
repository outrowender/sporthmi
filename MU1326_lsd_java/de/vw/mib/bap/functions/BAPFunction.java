/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.BAPFunctionListener;

public interface BAPFunction {
    public void indicationError(int var1, BAPFunctionListener var2);

    public void requestAcknowledge();

    public void errorAcknowledge();
}

