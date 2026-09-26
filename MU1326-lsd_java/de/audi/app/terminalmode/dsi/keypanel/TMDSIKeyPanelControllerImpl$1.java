/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelControllerImpl;

class TMDSIKeyPanelControllerImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$keyboardID;
    private final /* synthetic */ String val$language;
    private final /* synthetic */ int val$langCode;
    private final /* synthetic */ TMDSIKeyPanelControllerImpl this$0;

    TMDSIKeyPanelControllerImpl$1(TMDSIKeyPanelControllerImpl tMDSIKeyPanelControllerImpl, String string, int n, String string2, int n2) {
        this.this$0 = tMDSIKeyPanelControllerImpl;
        this.val$keyboardID = n;
        this.val$language = string2;
        this.val$langCode = n2;
        super(string);
    }

    @Override
    public void run() {
        TMDSIKeyPanelControllerImpl.access$000(this.this$0).updateRecognizerLanguage2(this.val$keyboardID, this.val$language, this.val$langCode);
    }
}

