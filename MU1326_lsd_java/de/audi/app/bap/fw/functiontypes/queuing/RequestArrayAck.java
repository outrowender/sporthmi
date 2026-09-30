/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;

public final class RequestArrayAck
extends AbstractArrayRequest {
    public RequestArrayAck(BAPFunctionArrayASG bAPFunctionArrayASG, int n) {
        super((AbstractBAPFunction)bAPFunctionArrayASG, 6, n);
    }

    public boolean responseIsExpected() {
        return false;
    }
}

