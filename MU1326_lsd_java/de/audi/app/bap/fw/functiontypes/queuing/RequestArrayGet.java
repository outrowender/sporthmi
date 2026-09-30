/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.vw.mib.bap.requests.GetArray;

public final class RequestArrayGet
extends AbstractArrayRequest {
    public RequestArrayGet(BAPFunctionArrayASG bAPFunctionArrayASG, int n, GetArray getArray) {
        super(bAPFunctionArrayASG, 2, getArray, n);
    }

    public boolean responseIsExpected() {
        return true;
    }
}

