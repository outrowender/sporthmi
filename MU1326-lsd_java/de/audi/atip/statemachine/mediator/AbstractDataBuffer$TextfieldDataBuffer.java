/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$TextfieldDataBuffer
extends AbstractDataBuffer {
    private String text1;
    private String text2;

    public AbstractDataBuffer$TextfieldDataBuffer(TextfieldModelGUI textfieldModelGUI) {
        this.text1 = textfieldModelGUI.getText1();
        this.text2 = textfieldModelGUI.getText2();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        TextfieldModelGUI textfieldModelGUI = (TextfieldModelGUI)((Object)hMIModel);
        boolean bl = !this.text1.equals(textfieldModelGUI.getText1()) || !this.text2.equals(textfieldModelGUI.getText2());
        this.text1 = textfieldModelGUI.getText1();
        this.text2 = textfieldModelGUI.getText2();
        return bl;
    }
}

