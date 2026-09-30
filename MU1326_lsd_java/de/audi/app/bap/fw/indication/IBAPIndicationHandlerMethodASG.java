/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.vw.mib.bap.requests.ResultMethod;

public interface IBAPIndicationHandlerMethodASG {
    public void processIndicationResult(BAPFunctionMethodASG var1, ResultMethod var2);
}

