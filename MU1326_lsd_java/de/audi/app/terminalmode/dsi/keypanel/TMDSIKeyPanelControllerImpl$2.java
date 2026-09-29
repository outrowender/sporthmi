/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl;

class TMDSIKeyPanelControllerImpl$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$keyboardID;
    private final /* synthetic */ int val$recognizerMode;
    private final /* synthetic */ TMDSIKeyPanelControllerImpl this$0;

    TMDSIKeyPanelControllerImpl$2(TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl, String string, int n, int n2) {
        this.this$0 = tMDSIKeyPanelControllerImpl;
        this.val$keyboardID = n;
        this.val$recognizerMode = n2;
        super(string);
    }

    @Override
    public void run() {
        TMDSIKeyPanelControllerImpl.access$000(this.this$0).updateRecognizerMode(this.val$keyboardID, this.val$recognizerMode);
    }
}

