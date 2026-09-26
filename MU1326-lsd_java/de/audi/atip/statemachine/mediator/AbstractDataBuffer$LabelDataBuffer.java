/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$LabelDataBuffer
extends AbstractDataBuffer {
    private String text;

    public AbstractDataBuffer$LabelDataBuffer(LabelModelGUI labelModelGUI) {
        this.text = labelModelGUI.getText();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        LabelModelGUI labelModelGUI = (LabelModelGUI)((Object)hMIModel);
        boolean bl = !this.text.equals(labelModelGUI.getText());
        this.text = labelModelGUI.getText();
        return bl;
    }
}

