/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$SpellerDataBuffer
extends AbstractDataBuffer {
    private String text;

    public AbstractDataBuffer$SpellerDataBuffer(SpellerModelGUI spellerModelGUI) {
        this.text = spellerModelGUI.getText();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        SpellerModelGUI spellerModelGUI = (SpellerModelGUI)((Object)hMIModel);
        boolean bl = !this.text.equals(spellerModelGUI.getText());
        this.text = spellerModelGUI.getText();
        return bl;
    }
}

