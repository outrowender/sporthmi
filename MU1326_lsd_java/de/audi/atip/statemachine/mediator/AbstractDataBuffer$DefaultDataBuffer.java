/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer$1;

class AbstractDataBuffer$DefaultDataBuffer
extends AbstractDataBuffer {
    private AbstractDataBuffer$DefaultDataBuffer() {
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        return true;
    }

    /* synthetic */ AbstractDataBuffer$DefaultDataBuffer(AbstractDataBuffer$1 abstractDataBuffer$1) {
        this();
    }
}

