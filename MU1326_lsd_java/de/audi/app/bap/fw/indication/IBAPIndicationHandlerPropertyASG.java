/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPIndicationHandlerPropertyASG {
    public void processIndicationStatus(BAPFunctionPropertyASG var1, StatusProperty var2);

    public void processIndicationStatusAck(BAPFunctionPropertyASG var1, StatusAckProperty var2);
}

