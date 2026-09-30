/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.vw.mib.bap.requests.SetGetArray;

public final class RequestArraySetGet
extends AbstractArrayRequest {
    public RequestArraySetGet(BAPFunctionArrayASG bAPFunctionArrayASG, int n, SetGetArray setGetArray) {
        super(bAPFunctionArrayASG, 0, setGetArray, n);
    }

    public boolean responseIsExpected() {
        return true;
    }
}

