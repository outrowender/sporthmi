/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractRequest;
import de.vw.mib.bap.requests.StartResultMethod;

public final class RequestMethodStartResult
extends AbstractRequest {
    public RequestMethodStartResult(AbstractBAPFunction abstractBAPFunction) {
        super(abstractBAPFunction, 4);
    }

    public RequestMethodStartResult(AbstractBAPFunction abstractBAPFunction, StartResultMethod startResultMethod) {
        super(abstractBAPFunction, 4, startResultMethod);
    }
}

