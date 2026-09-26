/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.vw.mib.bap.requests.ResultMethod;

public interface IBAPIndicationHandlerMethodASG {
    default public void processIndicationResult(BAPFunctionMethodASG bAPFunctionMethodASG, ResultMethod resultMethod) {
    }
}

