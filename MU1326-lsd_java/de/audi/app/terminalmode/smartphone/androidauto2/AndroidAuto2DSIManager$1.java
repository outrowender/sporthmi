/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager;

class AndroidAuto2DSIManager$1
implements ISpeechRequestHandler {
    private final /* synthetic */ AndroidAuto2DSIManager this$0;

    AndroidAuto2DSIManager$1(AndroidAuto2DSIManager androidAuto2DSIManager) {
        this.this$0 = androidAuto2DSIManager;
    }

    @Override
    public void startSpeechSession() {
        AndroidAuto2DSIManager.access$100(this.this$0, 84);
    }

    @Override
    public void abortActiveSpeechSession() {
        AndroidAuto2DSIManager.access$100(this.this$0, 84);
    }

    @Override
    public void prewarm() {
    }

    @Override
    public void cancelPrewarm() {
    }

    @Override
    public void pttReleasedAfterLongPress() {
    }
}

