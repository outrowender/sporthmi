/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.queuing.Request;
import de.vw.mib.bap.datatypes.BAPDataType;
import de.vw.mib.bap.datatypes.BAPEntity;

public abstract class AbstractRequest
implements Request {
    private final AbstractBAPFunction bapFunction;
    private final int bapRequestType;
    private final BAPEntity serializer;

    public AbstractRequest(AbstractBAPFunction abstractBAPFunction, int n) {
        this.bapFunction = abstractBAPFunction;
        this.bapRequestType = n;
        this.serializer = null;
    }

    public AbstractRequest(AbstractBAPFunction abstractBAPFunction, int n, BAPDataType bAPDataType) {
        this.bapFunction = abstractBAPFunction;
        this.bapRequestType = n;
        this.serializer = bAPDataType;
    }

    public final boolean send() {
        return this.bapFunction.sendRequest(this.bapRequestType, this.serializer);
    }
}

