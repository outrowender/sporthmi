/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$1;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;

class DSISmartphoneManagerProxy$SpeechRequestHandlerProxy
implements ISpeechRequestHandler {
    private final /* synthetic */ DSISmartphoneManagerProxy this$0;

    private DSISmartphoneManagerProxy$SpeechRequestHandlerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        this.this$0 = dSISmartphoneManagerProxy;
    }

    @Override
    public void prewarm() {
        DSISmartphoneManagerProxy.access$700(this.this$0).prewarm();
    }

    @Override
    public void abortActiveSpeechSession() {
        DSISmartphoneManagerProxy.access$700(this.this$0).abortActiveSpeechSession();
    }

    @Override
    public void cancelPrewarm() {
        DSISmartphoneManagerProxy.access$700(this.this$0).cancelPrewarm();
    }

    @Override
    public void startSpeechSession() {
        DSISmartphoneManagerProxy.access$700(this.this$0).startSpeechSession();
    }

    @Override
    public void pttReleasedAfterLongPress() {
        DSISmartphoneManagerProxy.access$700(this.this$0).pttReleasedAfterLongPress();
    }

    /* synthetic */ DSISmartphoneManagerProxy$SpeechRequestHandlerProxy(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, DSISmartphoneManagerProxy$1 dSISmartphoneManagerProxy$1) {
        this(dSISmartphoneManagerProxy);
    }
}

