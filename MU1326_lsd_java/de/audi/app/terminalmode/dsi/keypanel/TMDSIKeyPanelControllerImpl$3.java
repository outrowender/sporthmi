/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl;

class TMDSIKeyPanelControllerImpl$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$keyboardID;
    private final /* synthetic */ String[] val$recognizedCharacters;
    private final /* synthetic */ int[] val$confidence;
    private final /* synthetic */ TMDSIKeyPanelControllerImpl this$0;

    TMDSIKeyPanelControllerImpl$3(TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl, String string, int n, String[] stringArray, int[] nArray) {
        this.this$0 = tMDSIKeyPanelControllerImpl;
        this.val$keyboardID = n;
        this.val$recognizedCharacters = stringArray;
        this.val$confidence = nArray;
        super(string);
    }

    @Override
    public void run() {
        TMDSIKeyPanelControllerImpl.access$000(this.this$0).updateCharacterEvent2(this.val$keyboardID, this.val$recognizedCharacters, this.val$confidence);
    }
}

