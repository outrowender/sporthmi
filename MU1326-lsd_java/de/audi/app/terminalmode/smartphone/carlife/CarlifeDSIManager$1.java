/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager;

class CarlifeDSIManager$1
implements ISpeechRequestHandler {
    private final /* synthetic */ CarlifeDSIManager this$0;

    CarlifeDSIManager$1(CarlifeDSIManager carlifeDSIManager) {
        this.this$0 = carlifeDSIManager;
    }

    @Override
    public void startSpeechSession() {
        CarlifeDSIManager.access$000(this.this$0, 20);
    }

    @Override
    public void pttReleasedAfterLongPress() {
    }

    @Override
    public void prewarm() {
    }

    @Override
    public void cancelPrewarm() {
    }

    @Override
    public void abortActiveSpeechSession() {
        CarlifeDSIManager.access$000(this.this$0, 21);
    }
}

