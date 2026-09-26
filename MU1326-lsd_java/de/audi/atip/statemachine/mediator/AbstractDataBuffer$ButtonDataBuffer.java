/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$ButtonDataBuffer
extends AbstractDataBuffer {
    private boolean pressed;

    public AbstractDataBuffer$ButtonDataBuffer(ButtonModelGUI buttonModelGUI) {
        this.pressed = buttonModelGUI.getPressed();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((Object)hMIModel);
        boolean bl = this.pressed != buttonModelGUI.getPressed();
        this.pressed = buttonModelGUI.getPressed();
        return bl;
    }
}

