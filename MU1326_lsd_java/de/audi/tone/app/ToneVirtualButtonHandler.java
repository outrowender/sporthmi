/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class ToneVirtualButtonHandler
extends AbstractAppListener
implements ButtonListener {
    private final ButtonModelApp toneMmiTochVirtualButton;

    public ToneVirtualButtonHandler(ToneEnv toneEnv) {
        this.toneMmiTochVirtualButton = toneEnv.getButtonModel(1000112);
        this.toneMmiTochVirtualButton.setButtonListener(this);
    }

    public void keyTyped(int n, int n2, int n3) {
        AdditionalScreenData additionalScreenData = new AdditionalScreenData();
        additionalScreenData.addData(2, Boolean.TRUE);
        this.toneMmiTochVirtualButton.fireEvent(0, additionalScreenData);
    }
}

