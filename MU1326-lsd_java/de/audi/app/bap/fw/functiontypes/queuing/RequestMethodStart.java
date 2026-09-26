/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractRequest;
import de.vw.mib.bap.requests.StartResultMethod;

public final class RequestMethodStart
extends AbstractRequest {
    public RequestMethodStart(AbstractBAPFunction abstractBAPFunction) {
        super(abstractBAPFunction, 3);
    }

    public RequestMethodStart(AbstractBAPFunction abstractBAPFunction, StartResultMethod startResultMethod) {
        super(abstractBAPFunction, 3, startResultMethod);
    }
}

