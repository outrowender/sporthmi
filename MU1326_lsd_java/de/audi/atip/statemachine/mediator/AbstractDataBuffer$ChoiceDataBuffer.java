/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$ChoiceDataBuffer
extends AbstractDataBuffer {
    private int value;

    public AbstractDataBuffer$ChoiceDataBuffer(ChoiceModelGUI choiceModelGUI) {
        this.value = choiceModelGUI.getValue();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hMIModel);
        boolean bl = this.value != choiceModelGUI.getValue();
        this.value = choiceModelGUI.getValue();
        return bl;
    }
}

