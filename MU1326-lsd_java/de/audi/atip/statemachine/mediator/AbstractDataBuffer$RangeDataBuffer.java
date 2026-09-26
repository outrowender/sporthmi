/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$RangeDataBuffer
extends AbstractDataBuffer {
    private int value;

    public AbstractDataBuffer$RangeDataBuffer(RangeModelGUI rangeModelGUI) {
        this.value = rangeModelGUI.getValue();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        RangeModelGUI rangeModelGUI = (RangeModelGUI)((Object)hMIModel);
        boolean bl = this.value != rangeModelGUI.getValue();
        this.value = rangeModelGUI.getValue();
        return bl;
    }
}

