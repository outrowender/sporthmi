/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.queuing;

import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractRequest;
import de.vw.mib.bap.datatypes.BAPDataType;

public abstract class AbstractArrayRequest
extends AbstractRequest {
    private final int expectedTransactionId;

    public AbstractArrayRequest(AbstractBAPFunction abstractBAPFunction, int n, int n2) {
        super(abstractBAPFunction, n);
        this.expectedTransactionId = n2;
    }

    public AbstractArrayRequest(AbstractBAPFunction abstractBAPFunction, int n, BAPDataType bAPDataType, int n2) {
        super(abstractBAPFunction, n, bAPDataType);
        this.expectedTransactionId = n2;
    }

    public final int expectedTransactionId() {
        return this.expectedTransactionId;
    }

    public abstract boolean responseIsExpected() {
    }
}

