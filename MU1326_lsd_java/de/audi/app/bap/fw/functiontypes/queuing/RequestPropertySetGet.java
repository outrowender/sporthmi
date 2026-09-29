/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractRequest;
import de.vw.mib.bap.requests.SetGetProperty;

public final class RequestPropertySetGet
extends AbstractRequest {
    public RequestPropertySetGet(BAPFunctionPropertyASG bAPFunctionPropertyASG, SetGetProperty setGetProperty) {
        super(bAPFunctionPropertyASG, 0, setGetProperty);
    }
}

