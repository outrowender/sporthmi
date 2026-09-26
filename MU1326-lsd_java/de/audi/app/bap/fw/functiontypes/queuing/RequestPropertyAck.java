/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractRequest;
import de.vw.mib.bap.requests.AckProperty;

public final class RequestPropertyAck
extends AbstractRequest {
    public RequestPropertyAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, AckProperty ackProperty) {
        super(bAPFunctionPropertyASG, 6, ackProperty);
    }
}

