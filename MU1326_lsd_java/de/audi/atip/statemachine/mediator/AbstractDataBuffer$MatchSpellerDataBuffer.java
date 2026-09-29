/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.statemachine.mediator.AbstractDataBuffer;

class AbstractDataBuffer$MatchSpellerDataBuffer
extends AbstractDataBuffer {
    private String text;

    public AbstractDataBuffer$MatchSpellerDataBuffer(MatchspellerModelGUI matchspellerModelGUI) {
        this.text = matchspellerModelGUI.getText();
    }

    @Override
    public boolean valueChanged(HMIModel hMIModel) {
        MatchspellerModelGUI matchspellerModelGUI = (MatchspellerModelGUI)((Object)hMIModel);
        boolean bl = !this.text.equals(matchspellerModelGUI.getText());
        this.text = matchspellerModelGUI.getText();
        return bl;
    }
}

