/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.vw.mib.bap.requests.SetGetArray;

public final class RequestArraySet
extends AbstractArrayRequest {
    public RequestArraySet(BAPFunctionArrayASG bAPFunctionArrayASG, int n, SetGetArray setGetArray) {
        super(bAPFunctionArrayASG, 1, setGetArray, n);
    }

    @Override
    public boolean responseIsExpected() {
        return false;
    }
}

